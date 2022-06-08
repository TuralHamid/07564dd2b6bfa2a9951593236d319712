package com.space.challenge

import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import java.util.*

@HiltAndroidApp
class SpaceApplication : MultiDexApplication() {

  override fun onCreate() {
    super.onCreate()
    TimeZone.setDefault(TimeZone.getTimeZone("GMT+3"))
    Timber.plant(Timber.DebugTree())
  }
}