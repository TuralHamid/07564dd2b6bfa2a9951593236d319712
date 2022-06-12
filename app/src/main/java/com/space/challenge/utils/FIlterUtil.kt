package com.space.challenge.utils

import com.space.challenge.domain.model.Station

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

fun <T> List<T>.filterNotWorldStations(worldName: String): List<T> {
  return this.filterNot { item ->
    (item as Station).name.equals(worldName)
  }
}