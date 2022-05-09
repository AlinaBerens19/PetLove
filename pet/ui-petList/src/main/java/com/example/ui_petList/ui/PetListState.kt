package com.example.ui_petList.ui

import com.example.core.domain.ProgressBarState
import com.example.core.domain.Queue
import com.example.core.domain.UIComponent
import com.example.core.domain.UIComponentState
import com.example.pet_domain.*

data class PetListState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val pets: List<Pet> = listOf(),
    var filteredPets: List<Pet> = listOf(),
    val petFilter: PetFilter = PetFilter.Kind(),
    val primaryAttributeKinds: PetKinds = PetKinds.Cat(),
    val primaryAttributeBreeds: String = "",
    val primaryAttributeGender: PetGender = PetGender.Mail,
    val filterDialogState: UIComponentState = UIComponentState.Hide,
    val errorQueue: Queue<UIComponent> = Queue(mutableListOf()),
    val petName: String = ""
)
