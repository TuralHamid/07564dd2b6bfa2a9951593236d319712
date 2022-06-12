package com.space.challenge.domain.interactors.main

import com.space.challenge.domain.interactors.CompleteUseCase
import com.space.challenge.domain.model.FavoriteStation
import com.space.challenge.domain.repository.MainRepository
import javax.inject.Inject

class DeleteAllFavoritesUseCase @Inject constructor(
  private val mainRepository: MainRepository
) : CompleteUseCase<List<FavoriteStation>>() {

  override suspend fun buildResponse(param: List<FavoriteStation>) {
    return mainRepository.callDeleteAllFavStation(param)
  }
}