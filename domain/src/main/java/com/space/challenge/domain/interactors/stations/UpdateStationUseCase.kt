package com.space.challenge.domain.interactors.stations

import com.space.challenge.domain.interactors.CompleteUseCase
import com.space.challenge.domain.model.Station
import com.space.challenge.domain.repository.StationsRepository
import javax.inject.Inject

class UpdateStationUseCase @Inject constructor(
  private val stationsRepository: StationsRepository
) : CompleteUseCase<Station>() {
  override suspend fun buildResponse(param: Station) {
    return stationsRepository.callUpdateStation(param)
  }
}