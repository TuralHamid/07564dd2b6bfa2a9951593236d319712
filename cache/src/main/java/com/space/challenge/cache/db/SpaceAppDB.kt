package com.space.challenge.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.space.challenge.domain.model.FavoriteStation
import com.space.challenge.domain.model.Station

@Database(
  entities = [Station::class, FavoriteStation::class], version = 1, exportSchema = false
)
abstract class SpaceAppDB : RoomDatabase() {
  abstract fun stationDao(): StationDao
  abstract fun favStationDao(): FavStationDao
}