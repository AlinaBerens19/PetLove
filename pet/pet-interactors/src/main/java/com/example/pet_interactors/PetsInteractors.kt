package com.example.pet_interactors

import com.example.pet_datasource.cache.PetCache
import com.example.pet_interactors.filter.FilterPets
import com.example.pet_interactors.filter.FilterPetsByBreed
import com.example.pet_interactors.filter.FilterPetsByGender
import com.example.pet_interactors.filter.FilterPetsByKind
import com.squareup.sqldelight.db.SqlDriver


data class PetsInteractors(
    val getPets: GetPets,
    val getPetFromCache: GetPetFromCache,
    val insertAdIntoCache: InsertAdIntoCache,
    val petFilter: FilterPets,
    val filterByKind: FilterPetsByKind,
    val filterByGender: FilterPetsByGender,
    val filterByBreed: FilterPetsByBreed
)
{
    companion object Factory {
        fun build(sqlDriver: SqlDriver): PetsInteractors {
            val cache = PetCache.build(sqlDriver)
            return PetsInteractors(
                getPets = GetPets(
                    cache = cache
                ),
                getPetFromCache = GetPetFromCache(
                    cache = cache
                ),
                insertAdIntoCache = InsertAdIntoCache(
                    cache = cache
                ),
                petFilter = FilterPets(),
                filterByKind = FilterPetsByKind(),
                filterByGender = FilterPetsByGender(),
                filterByBreed = FilterPetsByBreed()
            )
        }

        val schema: SqlDriver.Schema = PetCache.schema

        val dbName: String = PetCache.dbName
    }
}

