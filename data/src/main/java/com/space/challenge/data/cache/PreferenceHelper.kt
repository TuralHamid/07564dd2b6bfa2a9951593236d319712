package com.space.challenge.data.cache

interface PreferenceHelper {
  fun putString(key: String, value: String)
  fun getString(key: String): String?
  fun getString(key: String, defaultValue: String): String?
  fun clear(key: String): Boolean
  fun getAll(): List<String>
  fun clearAll(): Boolean
}