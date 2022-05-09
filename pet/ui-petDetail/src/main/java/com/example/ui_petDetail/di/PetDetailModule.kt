package com.example.ui_petDetail.di


import com.example.pet_interactors.GetPetFromCache
import com.example.pet_interactors.PetsInteractors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object PetDetailModule {

    @Provides
    @Singleton
    fun provideGetPetFromCache(
        interactors: PetsInteractors
    ): GetPetFromCache
    {
        return interactors.getPetFromCache
    }
}