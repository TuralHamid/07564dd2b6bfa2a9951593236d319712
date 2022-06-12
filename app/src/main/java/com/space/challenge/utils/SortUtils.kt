package com.space.challenge.utils

import java.text.Collator
import java.util.*

fun <T> List<T>.sortStationsByName(): List<T> {
  return this.sortedWith { s1, s2 ->
    Collator.getInstance(getLocale()).compare(
      s1.toString(),
      s2.toString()
    )
  }
}

fun getLocale(): Locale {
  return Locale("tr", "TR")
}