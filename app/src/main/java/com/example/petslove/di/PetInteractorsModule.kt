package com.example.petslove.di

import android.app.Application
import com.example.pet_interactors.PetsInteractors
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object PetInteractorsModule {

    @Provides
    @Singleton
    @Named("petAndroidSqlDriver")
    fun provideAndroidDriver(app: Application): SqlDriver {
        return AndroidSqliteDriver(
            schema = PetsInteractors.schema,
            context = app,
            name = PetsInteractors.dbName
        )
    }

    @Provides
    @Singleton
    fun providePetsInteractors(
        @Named("petAndroidSqlDriver") sqlDriver: SqlDriver
    ): PetsInteractors
    {
        return PetsInteractors.build(sqlDriver)
    }

}



















