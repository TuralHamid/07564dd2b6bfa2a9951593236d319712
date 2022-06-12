package com.space.challenge.cache.db.impl

import com.space.challenge.cache.db.FavStationDao
import com.space.challenge.data.cache.FavoritesCache
import com.space.challenge.domain.model.FavoriteStation
import javax.inject.Inject

class FavStationsCacheImpl @Inject constructor(
  private val favStationDao: FavStationDao
) : FavoritesCache {

  override suspend fun callGetFavStations(): List<FavoriteStation>? {
    return favStationDao.getAll()
  }

  override suspend fun callInsertFavStation(favoriteStation: FavoriteStation) {
    return favStationDao.insert(favoriteStation)
  }

  override suspend fun callDeleteFavStation(favoriteStation: FavoriteStation) {
    return favStationDao.delete(favoriteStation)
  }

  override suspend fun callDeleteAllFavStation(favoriteStations: List<FavoriteStation>) {
    return favStationDao.deleteAll(favoriteStations)
  }
}