package com.space.challenge.data.remote

import com.space.challenge.domain.model.Station

interface StationsService {
  suspend fun callGetStations(): List<Station?>
}