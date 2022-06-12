package com.space.challenge.cache.db.impl

import com.space.challenge.cache.db.StationDao
import com.space.challenge.data.cache.StationCache
import com.space.challenge.domain.model.Station
import javax.inject.Inject

class StationCacheImpl @Inject constructor(
  private val stationDao: StationDao
) : StationCache {
  override suspend fun callGetStations(): List<Station>? {
    return stationDao.getAll()
  }

  override suspend fun callInsertAllStations(stations: List<Station>) {
    return stationDao.insertAll(stations)
  }

  override suspend fun callUpdateStation(station: Station) {
    return stationDao.update(station)
  }

  override suspend fun callDeleteAllStation(stations: List<Station>) {
    return stationDao.deleteAll(stations)
  }
}