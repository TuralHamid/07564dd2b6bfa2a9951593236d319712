package com.space.challenge.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class FavoriteStation(
  @PrimaryKey(autoGenerate = true)
  val st_id: Int,
  var fav: Int
) : Parcelable
