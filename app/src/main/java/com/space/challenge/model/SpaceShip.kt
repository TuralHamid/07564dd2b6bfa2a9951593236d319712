package com.space.challenge.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class SpaceShip(
  var name: String?,
  var durability: Int,
  var speed: Int,
  var capacity: Int
) : Parcelable