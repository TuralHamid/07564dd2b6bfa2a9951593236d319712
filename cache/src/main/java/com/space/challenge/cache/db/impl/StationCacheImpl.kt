package com.space.challenge.cache.db.impl

import com.space.challenge.cache.db.utils.fromJson
import com.space.challenge.cache.db.utils.toJson
import com.space.challenge.data.cache.PreferenceHelper
import com.space.challenge.data.cache.StationCache
import com.space.challenge.domain.model.Station
import com.squareup.moshi.Moshi
import java.io.IOException
import java.util.*
import javax.inject.Inject

class StationCacheImpl @Inject constructor(
  private val preferenceHelper: PreferenceHelper,
  private val moshi: Moshi
) : StationCache {
  override suspend fun callGetStations(): List<Station>? {
    val stationList = mutableListOf<Station>()
    for (str in preferenceHelper.getAll()) {
      try {
        stationList.add(moshi.fromJson(Station::class.java, str))

      } catch (e: IOException) {
        e.printStackTrace()
      }
    }
    return stationList
  }

  override suspend fun callInsertAllStations(stations: List<Station>) {
    for (station in stations) {
      station.id = UUID.randomUUID().toString()
      preferenceHelper.putString(station.id, moshi.toJson(Station::class.java, station))
    }
    return
  }

  override suspend fun callUpdateStation(station: Station) {
    preferenceHelper.putString(station.id, moshi.toJson(Station::class.java, station))
    return
  }

  override suspend fun callDeleteAllStation(stations: List<Station>) {
    preferenceHelper.clearAll()
    return
  }
}