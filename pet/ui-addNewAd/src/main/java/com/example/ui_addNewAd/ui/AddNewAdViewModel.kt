package com.example.ui_addNewAd.ui


import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.DataState
import com.example.core.domain.Queue
import com.example.core.domain.UIComponent
import com.example.pet_domain.Pet
import com.example.pet_interactors.GetPets
import com.example.pet_interactors.InsertAdIntoCache
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AddNewAdViewModel
@Inject
constructor(
    private val insertAdIntoCache: InsertAdIntoCache,
    private val getPets: GetPets,
): ViewModel()
{
    val state: MutableState<NewAdState> = mutableStateOf(NewAdState())

    fun onTriggerEvent(event: NewAdEvent) {
        when(event) {
            is NewAdEvent.SelectAllFromCache -> {
                selectAllFromCache()
                Log.d("TAG", "in cache: ${state.value.pets}")
            }
            is NewAdEvent.InsertNewAdToCache -> {
                insertNewAdToCache(event.pet)
                Log.d("TAG", "onTriggerEvent: ${state.value.pet}")
            }
        }
    }

    
    private fun insertNewAdToCache(pet: Pet) {
        insertAdIntoCache.execute(pet).onEach { dataState ->  
            when(dataState) {
                is DataState.Loading -> {
                    state.value = state.value.copy(progressBarState = dataState.progressBarState)
                }
                is DataState.Data -> {
                    state.value = dataState.data?.let { state.value.copy(pet = it) }!!
                }
                is DataState.Response -> {
                    //
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun selectAllFromCache() {
        getPets.execute(null).onEach { dataState ->
            when(dataState) {
                is DataState.Loading -> {
                    state.value = state.value.copy(progressBarState = dataState.progressBarState)
                }
                is DataState.Data -> {
                    state.value = dataState.data?.let { state.value.copy(pets = it) }!!
                }
                is DataState.Response -> {
                    if(dataState.uiComponent is UIComponent.None){
                        //LogD("getHeros: ${(dataState.uiComponent as UIComponent.None).message}")
                    }
                    else{
                        appendToMessageQueue(dataState.uiComponent)
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun appendToMessageQueue(uiComponent: UIComponent) {
        val queue = state.value.errorQueue
        queue.add(uiComponent)
        state.value = state.value.copy(errorQueue = Queue(mutableListOf()))
        state.value = state.value.copy(errorQueue = queue)
    }

}