package com.space.challenge.cache.db

import androidx.room.*
import com.space.challenge.domain.model.FavoriteStation

@Dao
interface FavStationDao {

  @Query("SELECT * FROM favoritestation")
  suspend fun getAll(): List<FavoriteStation>?

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insert(favoriteStation: FavoriteStation)

  @Delete
  suspend fun delete(favoriteStation: FavoriteStation)

  @Delete
  suspend fun deleteAll(favoriteStations: List<FavoriteStation>)
}