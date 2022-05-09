package com.example.pet_interactors.filter

import com.example.pet_domain.Pet

import com.example.pet_domain.PetGender


class FilterPetsByGender {

    fun execute(
        currentList: List<Pet>,
        attributeFilter: PetGender
    ): List<Pet> {

        var petGender: Int = 0

        petGender = when (attributeFilter) {
            is PetGender.Mail -> {
                0
            }
            is PetGender.Femail -> {
                1
            }
            else -> {
                0
            }
        }

        val filteredList: MutableList<Pet> = currentList.filter { pet ->
            pet.sex.toString().contains(petGender.toString())
        }.toMutableList()


        return filteredList
    }
}