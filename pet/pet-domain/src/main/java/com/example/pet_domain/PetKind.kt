package com.example.pet_domain



//TODO fetch strings from xml
sealed class PetKind(
    val uiValue: String,
) {

    object Cat : PetKind(
        uiValue = "Cat"
    )

    object Dog : PetKind(
        uiValue = "Dog"
    )

    object Horse : PetKind(
        uiValue = "Horse"
    )

    object Bird : PetKind(
        uiValue = "Bird"
    )

}