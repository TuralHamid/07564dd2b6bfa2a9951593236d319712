package com.space.challenge.domain.model

import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Station(
  var name: String?,
  var coordinateX: Double?,
  var coordinateY: Double?,
  var capacity: Long?,
  var stock: Long?,
  var need: Long?
) : Parcelable {

  @IgnoredOnParcel
  var isFavorite: Boolean = false

  @IgnoredOnParcel
  var pos: Int = -1
}