package com.space.challenge.domain.interactors.favorites

import com.space.challenge.domain.interactors.CompleteUseCase
import com.space.challenge.domain.model.FavoriteStation
import com.space.challenge.domain.repository.FavoritesRepository
import javax.inject.Inject

class DeleteFavoriteUseCase @Inject constructor(
  private val favoritesRepository: FavoritesRepository
) : CompleteUseCase<FavoriteStation>() {

  override suspend fun buildResponse(param: FavoriteStation) {
    return favoritesRepository.callDeleteFavStation(param)
  }
}