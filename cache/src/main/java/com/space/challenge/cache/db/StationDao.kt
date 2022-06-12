package com.space.challenge.cache.db

import androidx.room.*
import com.space.challenge.domain.model.Station

@Dao
interface StationDao {

  @Query("SELECT * FROM station")
  suspend fun getAll(): List<Station>?

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insert(station: Station)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertAll(stations: List<Station>)

  @Update
  suspend fun update(station: Station)

  @Delete
  suspend fun delete(station: Station)

  @Delete
  suspend fun deleteAll(stations: List<Station>)
}