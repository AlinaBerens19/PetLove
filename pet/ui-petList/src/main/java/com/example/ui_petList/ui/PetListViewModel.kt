package com.example.ui_petList.ui
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.DataState
import com.example.core.domain.Queue
import com.example.core.domain.UIComponent
import com.example.pet_domain.PetKinds
import com.example.pet_domain.PetFilter
import com.example.pet_domain.PetGender
import com.example.pet_interactors.filter.FilterPets
import com.example.pet_interactors.filter.FilterPetsByKind
import com.example.pet_interactors.GetPets
import com.example.pet_interactors.filter.FilterPetsByBreed
import com.example.pet_interactors.filter.FilterPetsByGender
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class PetListViewModel
@Inject
constructor(
    private val getPets: GetPets,
    private val filteredPets: FilterPets,
    private val filterPetsByKind: FilterPetsByKind,
    private val filterPetsByBreed: FilterPetsByBreed,
    private val filterPetsByGender: FilterPetsByGender
): ViewModel()
{
    val state: MutableState<PetListState> = mutableStateOf(PetListState())

    init {
        onTriggerEvent(ListStateEvent.AllPets)
    }

    fun onTriggerEvent(event: ListStateEvent) {
        when(event) {
            is ListStateEvent.UpdatePetName -> {
                updatePetName(event.petName)
                Log.d("TAG", "pet name: ${event.petName}")
            }
            is ListStateEvent.AllPets -> {
                selectAllFromCache()
                Log.d("TAG", "in cache: ${state.value.pets}")
            }
            is ListStateEvent.UpdatePetFilter -> {
                updatePetFilter(event.petFilter)
                Log.d("TAG", "in cache: ${state.value.pets}")
            }
            is ListStateEvent.FilteredPets -> {
                filterPets()
                Log.d("TAG", "filtered pets in cache: ${state.value.pets}")
            }
            is ListStateEvent.UpdateFilterDialogState -> {
                state.value = state.value.copy(filterDialogState = event.uiComponentState)
            }
            is ListStateEvent.UpdateFilterKindsAttributeState -> {
                state.value = state.value.copy(primaryAttributeKinds = event.petKinds)
                filterByPetBreed(event.petKinds)
            }
            is ListStateEvent.UpdateFilterGenderAttributeState -> {
                state.value = state.value.copy(primaryAttributeGender = event.petGender)
                filterByPetGender(event.petGender)
            }
            is ListStateEvent.UpdateFilterBreedsAttributeState -> {
                state.value = state.value.copy(primaryAttributeBreeds = event.petBreed)
                filterByPetBreed(event.petBreed)
            }
        }
    }

    private fun filterByPetBreed(petBreed: String){
        val filteredList = filterPetsByBreed.execute(
            currentList = state.value.pets,
            petBreed = petBreed
        )
        state.value = state.value.copy(filteredPets = filteredList)
        Log.w("TAG", "filterPets: ${state.value.pets}\"", )
    }

    private fun filterByPetGender(petGender: PetGender){
        val filteredList = filterPetsByGender.execute(
            currentList = state.value.pets,
            attributeFilter = petGender
        )
        state.value = state.value.copy(filteredPets = filteredList)
        Log.w("TAG", "filterPets: ${state.value.pets}\"", )
    }

    private fun filterByPetBreed(petBreed: PetKinds){
        val filteredList = filterPetsByKind.execute(
            currentList = state.value.pets,
            attributeFilter = petBreed
        )
        state.value = state.value.copy(filteredPets = filteredList)
        Log.w("TAG", "filterPets: ${state.value.pets}\"", )
    }

    private fun updatePetFilter(petFilter: PetFilter){
        state.value = state.value.copy(petFilter = petFilter)
        filterPets()
    }

    private fun updatePetName(petName: String) {
        state.value = state.value.copy(petName = petName)
        filterPets()
    }

    private fun selectAllFromCache() {
        getPets.execute(null).onEach { dataState ->
            when(dataState) {
                is DataState.Loading -> {
                    state.value = state.value.copy(progressBarState = dataState.progressBarState)
                }
                is DataState.Data -> {
                    state.value = dataState.data?.let { state.value.copy(pets = it) }!!
                    state.value = state.value.copy(filteredPets = state.value.pets)
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

    private fun filterPets(){
        val filteredList = filteredPets.execute(
            currentList = state.value.pets,
            petName = state.value.petName,
            petFilter = state.value.petFilter
        )
        state.value = state.value.copy(filteredPets = filteredList)
        Log.w("TAG", "filterPets: ${state.value.pets}\"", )
    }

    private fun appendToMessageQueue(uiComponent: UIComponent) {
        val queue = state.value.errorQueue
        queue.add(uiComponent)
        state.value = state.value.copy(errorQueue = Queue(mutableListOf()))
        state.value = state.value.copy(errorQueue = queue)
    }

}