package com.space.challenge.domain.repository

import com.space.challenge.domain.model.FavoriteStation
import com.space.challenge.domain.model.Station

interface StationsRepository {
  suspend fun callGetStations(): List<Station>?

  suspend fun callUpdateStation(station: Station)

  suspend fun callGetFavStations(): List<FavoriteStation>?

  suspend fun callInsertFavStation(favoriteStation: FavoriteStation)

  suspend fun callDeleteFavStation(favoriteStation: FavoriteStation)
}