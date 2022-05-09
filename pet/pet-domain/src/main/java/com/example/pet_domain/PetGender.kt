package com.example.pet_domain

sealed class PetGender(
    val value: String,
) {

    object Mail: PetGender(
        value = "mail"
    )

    object Femail: PetGender(
        value = "femail"
    )

}

