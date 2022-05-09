package com.example.ui_petDetail.ui

import com.example.core.domain.ProgressBarState
import com.example.core.domain.Queue
import com.example.core.domain.UIComponent
import com.example.pet_domain.Pet


data class DetailPetState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val pet: Pet? = null,
    val errorQueue: Queue<UIComponent> = Queue(mutableListOf())
)