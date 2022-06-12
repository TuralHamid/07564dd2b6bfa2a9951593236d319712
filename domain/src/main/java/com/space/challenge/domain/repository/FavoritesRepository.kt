package com.space.challenge.domain.repository

import com.space.challenge.domain.model.FavoriteStation

interface FavoritesRepository {
  suspend fun callGetFavStations(): List<FavoriteStation>?

  suspend fun callDeleteFavStation(favoriteStation: FavoriteStation)
}