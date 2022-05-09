package com.example.pet_interactors

import com.example.core.domain.DataState
import com.example.core.domain.ProgressBarState
import com.example.core.domain.UIComponent
import com.example.pet_datasource.cache.PetCache
import com.example.pet_domain.Pet
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class GetPets(
    //caching
    private val cache: PetCache,
    //TODO add service for interaction with network
)
{
    //probably we will need two execute() functions in the future.
    // One: to fetch list of pets from the network and cache it
    //and another one: to process uploaded by user ad
    fun execute(genderFilter: Boolean?): Flow<DataState<List<Pet>>> = flow {
        try {
            emit(DataState.Loading(progressBarState = ProgressBarState.Loading))
            //temporarily we save user ads from UI to cache. In the final version we will cache list of pets from network
            var cachedAds = cache.selectAll()

            if (genderFilter == true) {
                cachedAds = cache.selectAllMails()
            }
            if (genderFilter == false) {
                cachedAds = cache.selectAllFemails()
            }

            if(cachedAds.isNotEmpty()) {
                emit(DataState.Data(cachedAds))
            }

            else {
                emit(DataState.Response<List<Pet>>(
                    uiComponent = UIComponent.Dialog(
                        title = "Cache Data Error",
                        description = "Cache is empty"
                    )
                ))
            }

        }
        catch (e: Exception) {
            e.printStackTrace()

            emit(DataState.Response<List<Pet>>(
                uiComponent = UIComponent.Dialog(
                    title = "Error",
                    description = e.message?: "Unknown error"
                )
            ))
        }

        finally {
            emit(DataState.Loading(progressBarState = ProgressBarState.Idle))
        }
    }

}