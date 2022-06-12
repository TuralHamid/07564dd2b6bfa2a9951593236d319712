package com.space.challenge.cache.db.impl

import android.content.Context
import com.space.challenge.data.cache.PreferenceHelper
import javax.inject.Inject

class PreferenceHelperImpl @Inject constructor(context: Context) : PreferenceHelper {
  private val sharedPreferences = context.getSharedPreferences(PREF_BUFFER_PACKAGE_NAME, Context.MODE_PRIVATE)

  override fun putString(key: String, value: String) {
    sharedPreferences.edit().putString(key, value).apply()
  }

  override fun getString(key: String): String? {
    return getString(key, "")
  }

  override fun getString(key: String, defaultValue: String): String? {
    return sharedPreferences.getString(key, defaultValue)
  }

  override fun clear(key: String): Boolean {
    return sharedPreferences.edit().remove(key).commit()
  }

  override fun getAll(): List<String> {
    val list = mutableListOf<String>()
    for ((_, value) in sharedPreferences.all) {
      list.add(value.toString())
    }
    return list
  }

  override fun clearAll(): Boolean {
    return sharedPreferences.edit().clear().commit()
  }

  companion object {
    private const val PREF_BUFFER_PACKAGE_NAME = "com.space.challenge.cache"
  }
}