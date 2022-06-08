plugins {
  id("com.android.application") version "7.1.3" apply false
  id("com.android.library") version "7.1.3" apply false
  id("org.jetbrains.kotlin.android") version "1.5.30" apply false
}

buildscript {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
  }
  dependencies {
    classpath("com.android.tools.build:gradle:7.0.0")
    classpath("com.google.dagger:hilt-android-gradle-plugin:2.42")
  }
}

tasks.register("clean", Delete::class) {
  delete(rootProject.buildDir)
}