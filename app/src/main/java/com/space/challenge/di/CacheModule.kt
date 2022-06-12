package com.space.challenge.di

import android.content.Context
import androidx.room.Room
import com.space.challenge.cache.db.SpaceAppDB
import com.space.challenge.cache.db.StationDao
import com.space.challenge.cache.db.impl.StationCacheImpl
import com.space.challenge.data.cache.PreferenceHelper
import com.space.challenge.data.cache.StationCache
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

  @Provides
  @Singleton
  fun provideSpaceAppDB(@ApplicationContext appContext: Context): SpaceAppDB = Room.databaseBuilder(
    appContext,
    SpaceAppDB::class.java,
    "space_app.db"
  ).fallbackToDestructiveMigration().build()

  @Provides
  fun provideStationDao(spaceAppDB: SpaceAppDB): StationDao = spaceAppDB.stationDao()

  @Provides
  fun provideStationCache(
    preferenceHelper: PreferenceHelper,
    moshi: Moshi
  ): StationCache = StationCacheImpl(preferenceHelper, moshi)
}