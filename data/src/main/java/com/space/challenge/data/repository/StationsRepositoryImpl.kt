package com.space.challenge.data.repository

import com.space.challenge.data.remote.StationsService
import com.space.challenge.domain.model.Station
import com.space.challenge.domain.repository.StationsRepository
import javax.inject.Inject

class StationsRepositoryImpl @Inject constructor(
  private val stationsService: StationsService
) : StationsRepository {

  override suspend fun callGetStations(): List<Station?> {
    return stationsService.callGetStations()
  }
}