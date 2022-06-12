package com.space.challenge.domain.repository

import com.space.challenge.domain.model.Station

interface MainRepository {
  suspend fun callGetStations(): List<Station?>

  suspend fun callInsertAllStation(stations: List<Station>)

  suspend fun callDeleteAllStation(stations: List<Station>)
}