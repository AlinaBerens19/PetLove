package com.example.pet_interactors.filter

import com.example.pet_domain.Pet



class FilterPetsByBreed {

    fun execute(
        currentList: List<Pet>,
        petBreed: String
    ): List<Pet> {

        val filteredList: MutableList<Pet> = currentList.filter { pet ->
            pet.breed.lowercase().contains(petBreed.lowercase())
        }.toMutableList()


        return filteredList
    }

}