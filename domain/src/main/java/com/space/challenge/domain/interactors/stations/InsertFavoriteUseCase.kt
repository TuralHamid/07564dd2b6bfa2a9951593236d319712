package com.space.challenge.domain.interactors.stations

import com.space.challenge.domain.interactors.CompleteUseCase
import com.space.challenge.domain.model.FavoriteStation
import com.space.challenge.domain.repository.StationsRepository
import javax.inject.Inject

class InsertFavoriteUseCase @Inject constructor(
  private val stationsRepository: StationsRepository
) : CompleteUseCase<FavoriteStation>() {

  override suspend fun buildResponse(param: FavoriteStation) {
    return stationsRepository.callInsertFavStation(param)
  }
}