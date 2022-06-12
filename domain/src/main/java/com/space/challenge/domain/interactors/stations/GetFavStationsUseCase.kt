package com.space.challenge.domain.interactors.stations

import com.space.challenge.domain.interactors.FlowUseCase
import com.space.challenge.domain.model.FavoriteStation
import com.space.challenge.domain.repository.StationsRepository
import javax.inject.Inject

class GetFavStationsUseCase @Inject constructor(
  private val stationsRepository: StationsRepository
) : FlowUseCase<List<FavoriteStation>?>() {
  override suspend fun buildResponse(): List<FavoriteStation>? {
    return stationsRepository.callGetFavStations()
  }
}