package com.space.challenge.cache.db.utils

import com.squareup.moshi.Moshi

fun <T> Moshi.fromJson(clazz: Class<T>, json: String): T {
  return this.adapter(clazz).fromJson(json) ?: clazz.newInstance()
}

fun <T> Moshi.toJson(clazz: Class<T>, data: T): String {
  return this.adapter(clazz).toJson(data)
}
