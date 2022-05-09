package com.example.pet_interactors.filter

import com.example.pet_domain.FilterOrder
import com.example.pet_domain.Pet
import com.example.pet_domain.PetFilter


class FilterPets {

    fun execute(
        currentList: List<Pet>,
        petName: String,
        petFilter: PetFilter,
    ): List<Pet> {

        val filteredList: MutableList<Pet> = currentList.filter { pet ->
            pet.breed.lowercase().contains(petName.lowercase()) ||
            pet.kind.lowercase().contains(petName.lowercase())
        }.toMutableList()

        when (petFilter) {
            is PetFilter.Kind -> {
                when (petFilter.order) {
                    is FilterOrder.Descending -> {
                        filteredList.sortByDescending { it.kind }
                    }
                    is FilterOrder.Ascending -> {
                        filteredList.sortBy { it.kind }
                    }
                }
            }
        }
        return filteredList
    }
}