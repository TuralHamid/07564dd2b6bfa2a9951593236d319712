package com.space.challenge.data.repository

import com.space.challenge.data.cache.FavoritesCache
import com.space.challenge.data.cache.StationCache
import com.space.challenge.domain.model.FavoriteStation
import com.space.challenge.domain.model.Station
import com.space.challenge.domain.repository.StationsRepository
import javax.inject.Inject

class StationsRepositoryImpl @Inject constructor(
  private val stationCache: StationCache,
  private val favStationCache: FavoritesCache
) : StationsRepository {
  override suspend fun callGetStations(): List<Station>? {
    return stationCache.callGetStations()
  }

  override suspend fun callUpdateStation(station: Station) {
    return stationCache.callUpdateStation(station)
  }

  override suspend fun callGetFavStations(): List<FavoriteStation>? {
    return favStationCache.callGetFavStations()
  }

  override suspend fun callInsertFavStation(favoriteStation: FavoriteStation) {
    return favStationCache.callInsertFavStation(favoriteStation)
  }

  override suspend fun callDeleteFavStation(favoriteStation: FavoriteStation) {
    return favStationCache.callDeleteFavStation(favoriteStation)
  }
}