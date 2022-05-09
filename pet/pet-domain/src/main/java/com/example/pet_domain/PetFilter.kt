package com.example.pet_domain



sealed class PetFilter(val uiValue: String){

    data class Breed(
        val order: FilterOrder = FilterOrder.Descending
    ) : PetFilter("Breed")

    data class Kind(
        val order: FilterOrder = FilterOrder.Descending
    ) : PetFilter("Kind")

    data class Gender(
        val order: FilterOrder = FilterOrder.Descending
    ) : PetFilter("Gender")


}