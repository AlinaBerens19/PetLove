package com.example.ui_petList.di

import com.example.pet_interactors.GetPets
import com.example.pet_interactors.PetsInteractors
import com.example.pet_interactors.filter.FilterPets
import com.example.pet_interactors.filter.FilterPetsByBreed
import com.example.pet_interactors.filter.FilterPetsByGender
import com.example.pet_interactors.filter.FilterPetsByKind
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PetListModule {

    @Provides
    @Singleton
    fun provideGetPets(
        interactors: PetsInteractors
    ): GetPets {
        return interactors.getPets
    }

    @Provides
    @Singleton
    fun provideFilterPets(
        interactors: PetsInteractors
    ): FilterPets {
        return interactors.petFilter
    }

    @Provides
    @Singleton
    fun provideFilterPetsByKind(
        interactors: PetsInteractors
    ): FilterPetsByKind {
        return interactors.filterByKind
    }

    @Provides
    @Singleton
    fun provideFilterPetsByGender(
        interactors: PetsInteractors
    ): FilterPetsByGender {
        return interactors.filterByGender
    }

    @Provides
    @Singleton
    fun provideFilterPetsByBreed(
        interactors: PetsInteractors
    ): FilterPetsByBreed {
        return interactors.filterByBreed
    }



}