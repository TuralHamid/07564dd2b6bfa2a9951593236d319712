package com.space.challenge.di

import com.space.challenge.data.remote.StationsService
import com.space.challenge.data.repository.StationsRepositoryImpl
import com.space.challenge.domain.repository.StationsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

  @Provides
  @Singleton
  fun provideStationRepository(stationsService: StationsService): StationsRepository = StationsRepositoryImpl(stationsService)
}