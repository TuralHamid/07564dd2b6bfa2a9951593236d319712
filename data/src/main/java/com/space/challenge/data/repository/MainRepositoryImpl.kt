package com.space.challenge.data.repository

import com.space.challenge.data.cache.StationCache
import com.space.challenge.data.remote.StationsService
import com.space.challenge.domain.model.Station
import com.space.challenge.domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
  private val stationsService: StationsService,
  private val stationCache: StationCache,
) : MainRepository {
  override suspend fun callGetStations(): List<Station?> {
    return stationsService.callGetStations()
  }

  override suspend fun callInsertAllStation(stations: List<Station>) {
    return stationCache.callInsertAllStations(stations)
  }

  override suspend fun callDeleteAllStation(stations: List<Station>) {
    return stationCache.callDeleteAllStation(stations)
  }
}