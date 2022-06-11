package com.space.challenge.network.service

import com.space.challenge.domain.model.Station
import retrofit2.http.GET

interface Services {
  @GET(ApiPath.apiPath)
  suspend fun callGetStations(): List<Station?>
}