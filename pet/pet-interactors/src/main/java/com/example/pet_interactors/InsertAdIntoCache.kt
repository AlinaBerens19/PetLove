package com.example.pet_interactors

import com.example.core.domain.DataState
import com.example.core.domain.ProgressBarState
import com.example.pet_datasource.cache.PetCache
import com.example.pet_domain.Pet
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


//TODO upload ad to server.
//Currently it saves ad to cache for test purpose
class


InsertAdIntoCache(
    private val cache: PetCache,
)
{
    fun execute(
        pet: Pet
    ): Flow<DataState<Pet>> = flow {
        try {

            emit(DataState.Loading(progressBarState = ProgressBarState.Loading))

            cache.insert(pet)

            emit(DataState.Data(pet))

        }
        catch (e: Exception) {
            e.printStackTrace()
            print("Next exception thrown on attempt to insert ad to cache: $e")
        }
        finally {
            //TODO emit loading to stop progress bar - Idle state
            emit(DataState.Loading(progressBarState = ProgressBarState.Idle))
        }
    }
}