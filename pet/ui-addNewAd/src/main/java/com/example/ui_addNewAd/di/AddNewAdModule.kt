package com.example.ui_addNewAd.di

import com.example.pet_interactors.InsertAdIntoCache
import com.example.pet_interactors.PetsInteractors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AddNewAdModule {

    @Provides
    @Singleton
    fun provideInsertAd(
        interactors: PetsInteractors
    ): InsertAdIntoCache {
        return interactors.insertAdIntoCache
    }



}