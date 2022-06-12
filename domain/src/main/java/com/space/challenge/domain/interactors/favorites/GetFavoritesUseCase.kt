package com.space.challenge.domain.interactors.favorites

import com.space.challenge.domain.interactors.FlowUseCase
import com.space.challenge.domain.model.FavoriteStation
import com.space.challenge.domain.repository.FavoritesRepository
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(
  private val favoritesRepository: FavoritesRepository
) : FlowUseCase<List<FavoriteStation>?>() {

  override suspend fun buildResponse(): List<FavoriteStation>? {
    return favoritesRepository.callGetFavStations()
  }
}