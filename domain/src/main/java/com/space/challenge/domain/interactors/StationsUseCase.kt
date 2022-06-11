package com.space.challenge.domain.interactors

import com.space.challenge.domain.model.Station
import com.space.challenge.domain.repository.StationsRepository
import javax.inject.Inject

class StationsUseCase @Inject constructor(
  private val stationsRepository: StationsRepository
) : FlowUseCase<List<Station?>>() {

  override suspend fun buildFlow(): List<Station?> {
    return stationsRepository.callGetStations()
  }
}