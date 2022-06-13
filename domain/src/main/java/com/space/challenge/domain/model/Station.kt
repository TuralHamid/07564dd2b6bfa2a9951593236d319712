package com.space.challenge.domain.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Station(
  var name: String?,
  var coordinateX: Double?,
  var coordinateY: Double?,
  var capacity: Long?,
  var stock: Long?,
  var need: Long?
) : Parcelable {

  @IgnoredOnParcel
  var id: String = ""

  @IgnoredOnParcel
  var isFavorite: Boolean = false

  @IgnoredOnParcel
  var isTraveled: Boolean = false

  @IgnoredOnParcel
  var eus: Double = 0.0

  @IgnoredOnParcel
  var pos: Int = -1
}