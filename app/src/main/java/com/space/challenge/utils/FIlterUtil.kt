package com.space.challenge.utils

import com.space.challenge.model.Station

fun <T> List<T>.filterSearchedStations(searchText: String): List<T> {
  return this.filter { item ->
    (item as Station).name?.contains(searchText, ignoreCase = true) ?: false
  }
}

fun <T> List<T>.filterFavoriteStations(): List<T> {
  return this.filter { item ->
    (item as Station).isFavorite
  }
}