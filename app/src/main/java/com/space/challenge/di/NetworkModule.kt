package com.space.challenge.di

import com.space.challenge.data.remote.StationsService
import com.space.challenge.network.ServiceCreator
import com.space.challenge.network.impl.StationsServiceImpl
import com.space.challenge.network.interceptors.DefaultHeaderInterceptor
import com.space.challenge.network.service.Services
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

  @Provides
  @Singleton
  fun provideDefaultHeaderInterceptor(): DefaultHeaderInterceptor = DefaultHeaderInterceptor()

  @Provides
  @Singleton
  fun provideStationService(services: Services): StationsService = StationsServiceImpl(services)

  @Provides
  @Singleton
  fun serviceCreator(
    @Named("api_url") apiUrl: String,
    defaultHeaderInterceptor: DefaultHeaderInterceptor,
    moshi: Moshi
  ): ServiceCreator = ServiceCreator(apiUrl, defaultHeaderInterceptor, moshi)

  @Provides
  fun provideServices(serviceCreator: ServiceCreator): Services = serviceCreator.createService(Services::class.java)
}