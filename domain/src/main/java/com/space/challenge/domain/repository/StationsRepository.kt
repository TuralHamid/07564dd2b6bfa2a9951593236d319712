package com.space.challenge.domain.repository

import com.space.challenge.domain.model.Station

interface StationsRepository {
  suspend fun callGetStations(): List<Station?>
}