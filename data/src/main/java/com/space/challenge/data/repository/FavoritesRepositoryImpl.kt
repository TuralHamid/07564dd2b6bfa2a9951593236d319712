package com.space.challenge.data.repository

import com.space.challenge.data.cache.FavoritesCache
import com.space.challenge.domain.model.FavoriteStation
import com.space.challenge.domain.repository.FavoritesRepository
import javax.inject.Inject

class FavoritesRepositoryImpl @Inject constructor(
  private val favoritesCache: FavoritesCache
) : FavoritesRepository {

  override suspend fun callGetFavStations(): List<FavoriteStation>? {
    return favoritesCache.callGetFavStations()
  }

  override suspend fun callDeleteFavStation(favoriteStation: FavoriteStation) {
    return favoritesCache.callDeleteFavStation(favoriteStation)
  }
}