package com.example.pet_interactors.filter

import com.example.pet_domain.Pet
import com.example.pet_domain.PetKinds


class FilterPetsByKind {

    fun execute(
        currentList: List<Pet>,
        attributeFilter: PetKinds
    ): List<Pet> {

        var petKind: String = ""

        petKind = when (attributeFilter) {
            is PetKinds.Cat -> {
                "cat"
            }
            is PetKinds.Dog -> {
                "dog"
            }
            is PetKinds.Horse -> {
                "horse"
            }
        }

        val filteredList: MutableList<Pet> = currentList.filter { pet ->
            pet.kind.lowercase().contains(petKind.lowercase())
        }.toMutableList()


        return filteredList
    }
}