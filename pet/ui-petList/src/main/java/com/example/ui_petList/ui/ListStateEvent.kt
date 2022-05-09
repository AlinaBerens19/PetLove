package com.example.ui_petList.ui


import com.example.core.domain.UIComponentState
import com.example.pet_domain.PetKinds
import com.example.pet_domain.PetFilter
import com.example.pet_domain.PetGender
import com.example.pet_domain.PetKind


sealed class ListStateEvent {

    object AllPets: ListStateEvent()

    object FilteredPets: ListStateEvent()


    data class UpdatePetFilter(
        val petFilter: PetFilter
    ): ListStateEvent()

    data class UpdatePetName(
        val petName: String = ""
    ): ListStateEvent()

    data class UpdateFilterDialogState(
        val uiComponentState: UIComponentState
    ): ListStateEvent()

    data class UpdateFilterKindsAttributeState(
        val petKinds: PetKinds
    ): ListStateEvent()

    data class UpdateFilterBreedsAttributeState(
        val petBreed: String
    ): ListStateEvent()

    data class UpdateFilterGenderAttributeState(
        val petGender: PetGender
    ): ListStateEvent()
}