package com.space.challenge.data.cache

import com.space.challenge.domain.model.FavoriteStation

interface FavoritesCache {
  suspend fun callGetFavStations(): List<FavoriteStation>?

  suspend fun callInsertFavStation(favoriteStation: FavoriteStation)

  suspend fun callDeleteFavStation(favoriteStation: FavoriteStation)

  suspend fun callDeleteAllFavStation(favoriteStations: List<FavoriteStation>)
}