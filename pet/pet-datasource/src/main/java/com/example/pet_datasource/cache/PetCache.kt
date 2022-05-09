package com.example.pet_datasource.cache

import com.example.hero_datasource.cache.PetDatabase
import com.example.pet_domain.Pet
import com.squareup.sqldelight.db.SqlDriver

interface PetCache {

    suspend fun getPet(id: String): Pet?

    suspend fun removePet(id: String)

    suspend fun selectAll(): List<Pet>

    suspend fun insert(pet: Pet)

    suspend fun insert(pets: List<Pet>)

    suspend fun searchByKind(kind: String): List<Pet>

    suspend fun searchByBreed(breed: String): List<Pet>

    suspend fun selectAllMails(): List<Pet>

    suspend fun selectAllFemails(): List<Pet>

    companion object Factory {
        fun build(sqlDriver: SqlDriver): PetCache {
            return PetCacheImpl(PetDatabase(sqlDriver))
        }

        val schema: SqlDriver.Schema = PetDatabase.Schema

        val dbName: String = "pets.db"
    }


}