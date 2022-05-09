package com.example.ui_petDetail.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.DataState
import com.example.pet_interactors.GetPetFromCache
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class DetailPetViewModel
@Inject
constructor(
    private val getPetFromCache: GetPetFromCache,
    private val savedStateHandle: SavedStateHandle,
): ViewModel(){

    val state: MutableState<DetailPetState> = mutableStateOf(DetailPetState())

    init {
        savedStateHandle.get<String>("petId")?.let { petId ->
            onTriggerEvent(DetailPetEvents.GetPetFromCache(petId))
        }
    }

    fun onTriggerEvent(event: DetailPetEvents) {
        when (event) {
            is DetailPetEvents.GetPetFromCache -> {
                getHeroFromCache(event.id)
            }
        }
    }

    private fun getHeroFromCache(id: String){
        getPetFromCache.execute(id).onEach { dataState ->
            when(dataState){
                is DataState.Loading -> {
                    state.value = state.value.copy(progressBarState = dataState.progressBarState)
                }
                is DataState.Data -> {
                    state.value = state.value.copy(pet = dataState.data)
                }
                is DataState.Response -> {
                    // TODO(Handle errors)
                }
            }
        }.launchIn(viewModelScope)
    }

}
