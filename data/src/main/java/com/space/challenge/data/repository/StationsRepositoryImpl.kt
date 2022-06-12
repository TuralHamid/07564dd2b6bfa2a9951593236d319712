package com.space.challenge.data.repository

import com.space.challenge.data.cache.StationCache
import com.space.challenge.domain.model.Station
import com.space.challenge.domain.repository.StationsRepository
import javax.inject.Inject

class StationsRepositoryImpl @Inject constructor(
  private val stationCache: StationCache
) : StationsRepository {

  override suspend fun callGetStations(): List<Station>? {
    return stationCache.callGetStations()
  }

  override suspend fun callUpdateStation(station: Station) {
    return stationCache.callUpdateStation(station)
  }
}