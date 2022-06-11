package com.space.challenge.network.impl

import com.space.challenge.data.remote.StationsService
import com.space.challenge.domain.model.Station
import com.space.challenge.network.service.Services
import javax.inject.Inject

class StationsServiceImpl @Inject constructor(private val services: Services) : StationsService {

  override suspend fun callGetStations(): List<Station?> {
    return services.callGetStations()
  }
}