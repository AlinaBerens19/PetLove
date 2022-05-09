package com.example.pet_domain



sealed class FilterOrder {

    object Ascending: FilterOrder()

    object Descending: FilterOrder()

}
