package com.example.pet_datasource.cache

import com.example.hero_datasource.cache.PetDatabase
import com.example.herodatasource.cache.PetDbQueries
import com.example.pet_domain.Pet


class PetCacheImpl(
    petDatabase: PetDatabase
): PetCache
{
    private var queries: PetDbQueries = petDatabase.petDbQueries

    override suspend fun getPet(id: String): Pet {
        return queries.getPet(id).executeAsOne().toPet()
    }

    override suspend fun removePet(id: String) {
        queries.deletePet(id)
    }

    override suspend fun selectAll(): List<Pet> {
        return queries.selectAll().executeAsList().map { it.toPet() }
    }

    override suspend fun insert(pet: Pet) {
        return pet.run {
            queries.insertPet(
                id = id,
                kind = kind,
                name = name,
                age = age.toLong(),
                breed = breed,
                sex = sex.toLong(),
                ownerSex = ownerSex.toLong(),
                place = place,
                ownerName = ownerName,
                ownerPhone = ownerPhone,
                ownerEmail = ownerEmail,
                aboutPetInfo = aboutPetInfo,
                likes = likes.toLong(),
                firstImage = image,
                secondImage = images?.get(1),
                thirdImage = images?.get(2),
                forthImage = images?.get(3),
                fifthImage = images?.get(4),
            )
        }
    }

    override suspend fun insert(pets: List<Pet>) {
        for (pet in pets) {
            try {
                insert(pet)
            }
            catch (e: Exception) {
                e.printStackTrace()
                //if one has error just continue with others***
            }
        }
    }

    override suspend fun searchByKind(kind: String): List<Pet> {
        return queries.searchPetByKind(kind).executeAsList().map { it.toPet() }
    }

    override suspend fun searchByBreed(breed: String): List<Pet> {
        return queries.searchPetByBreed(breed).executeAsList().map { it.toPet() }
    }

    override suspend fun selectAllMails(): List<Pet> {
        return queries.selectAllMails().executeAsList().map { it.toPet() }
    }

    override suspend fun selectAllFemails(): List<Pet> {
        return queries.selectAllFemails().executeAsList().map { it.toPet() }
    }

}