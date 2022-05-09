package com.example.ui_addNewAd.ui

import com.example.pet_domain.Pet


sealed class NewAdEvent {

    //for test purposes
    object SelectAllFromCache: NewAdEvent()

    data class InsertNewAdToCache(
        val pet: Pet
    ): NewAdEvent()

    data class PetKind(
        val kind: String
    ): NewAdEvent()

}
