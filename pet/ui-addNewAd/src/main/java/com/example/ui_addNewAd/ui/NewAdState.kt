package com.example.ui_addNewAd.ui

import android.net.Uri
import android.util.Log
import com.example.core.domain.ProgressBarState
import com.example.core.domain.Queue
import com.example.core.domain.UIComponent
import com.example.pet_domain.Pet

data class NewAdState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    var pet: Pet? = null,
    val pets: List<Pet>? = null,
    var name: String = "",
    var ownerName: String = "",
    var phone: String = "",
    var email: String = "",
    var place: String = "",
    var age: Int? = null,
    var kind: String = "Cat",
    var breed: String = "Choose your pet breed",
    var sex: Int = 0,
    var info: String = "",
    val errorQueue: Queue<UIComponent> = Queue(mutableListOf()),
    var uri: Uri? = null
)


