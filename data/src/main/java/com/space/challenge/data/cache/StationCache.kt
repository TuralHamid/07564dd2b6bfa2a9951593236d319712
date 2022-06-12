package com.space.challenge.data.cache

import com.space.challenge.domain.model.Station

interface StationCache {
  suspend fun callGetStations(): List<Station>?

  suspend fun callInsertAllStations(stations: List<Station>)

  suspend fun callUpdateStation(station: Station)

  suspend fun callDeleteAllStation(stations: List<Station>)
}