package com.space.challenge.di

import android.content.Context
import com.space.challenge.BuildConfig
import com.space.challenge.cache.db.impl.PreferenceHelperImpl
import com.space.challenge.data.cache.PreferenceHelper
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

  @Provides
  @Singleton
  @Named("api_url")
  fun provideApiUrl(): String = BuildConfig.API_BASE_URL

  @Provides
  @Singleton
  fun provideMoshi(moshiBuilder: Moshi.Builder): Moshi = moshiBuilder.build()

  @Provides
  @Singleton
  fun provideMoshBuilder(): Moshi.Builder = Moshi.Builder().add(KotlinJsonAdapterFactory())

  @Provides
  @Singleton
  fun providePreferenceHelper(@ApplicationContext context: Context): PreferenceHelper = PreferenceHelperImpl(context)
}