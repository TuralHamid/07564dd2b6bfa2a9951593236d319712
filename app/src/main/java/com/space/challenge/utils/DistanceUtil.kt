package com.space.challenge.utils

import kotlin.math.pow
import kotlin.math.sqrt

fun getDistance(x: Double, y: Double, currentXCoordinate: Double, currentYCoordinate: Double): Double {
  return sqrt(((x.minus(currentXCoordinate)).pow(2).plus((y.minus(currentYCoordinate)).pow(2))))
}