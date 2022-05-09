package com.example.pet_interactors

import com.example.core.domain.DataState
import com.example.core.domain.ProgressBarState
import com.example.pet_datasource.cache.PetCache
import com.example.pet_domain.Pet
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class GetPetFromCache(
    private val cache: PetCache,
)
{

    fun execute(
        id: String
    ): Flow<DataState<Pet>> = flow {
        try {
            emit(DataState.Loading(progressBarState = ProgressBarState.Loading))

            val cachedPet = cache.getPet(id) ?: throw Exception("That pet doesn't exist")

            emit(DataState.Data(cachedPet))

        }
        catch (e: Exception) {
            e.printStackTrace()
            print("Next exception thrown during fetching from cache: $e")
        }
        finally {
            //TODO emit loading to stop progress bar - Idle state
            emit(DataState.Loading(progressBarState = ProgressBarState.Idle))
        }
    }

}