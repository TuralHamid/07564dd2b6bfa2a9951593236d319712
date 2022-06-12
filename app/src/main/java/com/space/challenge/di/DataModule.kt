package com.space.challenge.di

import com.space.challenge.data.cache.StationCache
import com.space.challenge.data.remote.StationsService
import com.space.challenge.data.repository.MainRepositoryImpl
import com.space.challenge.data.repository.StationsRepositoryImpl
import com.space.challenge.domain.repository.MainRepository
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
  fun provideMainRepository(
    stationsService: StationsService,
    stationCache: StationCache,
  ): MainRepository = MainRepositoryImpl(stationsService, stationCache)

  @Provides
  @Singleton
  fun provideStationRepository(
    stationCache: StationCache
  ): StationsRepository = StationsRepositoryImpl(stationCache)
}