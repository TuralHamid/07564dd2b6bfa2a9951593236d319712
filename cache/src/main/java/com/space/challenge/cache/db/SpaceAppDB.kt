package com.space.challenge.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.space.challenge.domain.model.Station

@Database(
  entities = [Station::class], version = 1, exportSchema = false
)
abstract class SpaceAppDB : RoomDatabase() {
  abstract fun stationDao(): StationDao
}