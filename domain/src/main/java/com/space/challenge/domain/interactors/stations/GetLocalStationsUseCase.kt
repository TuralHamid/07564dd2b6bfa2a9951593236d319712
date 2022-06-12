package com.space.challenge.domain.interactors.stations

import com.space.challenge.domain.interactors.FlowUseCase
import com.space.challenge.domain.model.Station
import com.space.challenge.domain.repository.StationsRepository
import javax.inject.Inject

class GetLocalStationsUseCase @Inject constructor(
  private val stationsRepository: StationsRepository
) : FlowUseCase<List<Station>?>() {
  override suspend fun buildResponse(): List<Station>? {
    return stationsRepository.callGetStations()
  }
}