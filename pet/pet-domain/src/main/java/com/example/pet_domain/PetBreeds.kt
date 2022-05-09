package com.example.pet_domain

val AllCatBreeds = arrayOf<String>("persian", "british", "siam")

sealed class PetKinds (
    val kindValue: String
) {
    data class Cat(
        val breedValue: String = "persian"
    ) : PetKinds("Cat")

    data class Dog(
        val breedValue: String = "akita"
    ) : PetKinds("Dog")

    data class Horse(
        val breedValue: String = "arabian horse"
    ) : PetKinds("Horse")
}

enum class PetBreeds {
    CatBreeds, DogBreeds, HorseBreeds
}

sealed class CatBreeds(
    val uiValue: String
) {

    object Persian : CatBreeds(
        uiValue = "persian"
    )

    object British : CatBreeds(
        uiValue = "british"
    )

    object MaineCoon : CatBreeds(
        uiValue = "maine coon"
    )

}

sealed class DogBreeds(
    val uiValue: String
) {

    object Akita : DogBreeds(
        uiValue = "akita"
    )

    object Bulldog : DogBreeds(
        uiValue = "bulldog"
    )

    object Collie : DogBreeds(
        uiValue = "collie"
    )

}

sealed class HorseBreeds(
    val uiValue: String
) {

    object ArabianHorse : HorseBreeds(
        uiValue = "arabian horse"
    )

    object Morgan : HorseBreeds(
        uiValue = "morgan"
    )

    object Ponies : HorseBreeds(
        uiValue = "ponies"
    )

}
