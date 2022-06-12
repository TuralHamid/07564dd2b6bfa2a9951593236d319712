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
    classpath("com.google.dagger:hilt-android-gradle-plugin:2.38.1")
  }
}

subprojects {
  configurations.all {
    resolutionStrategy.eachDependency {
      val requested = requested
      if (requested.group == "org.jetbrains.kotlin" &&
        (requested.name == "kotlin-stdlib-jdk8" ||
          requested.name == "kotlin-stdlib-jdk7" ||
          requested.name == "kotlin-reflect" ||
          requested.name == "kotlin-stdlib" ||
          requested.name == "kotlin-stdlib-common")
      ) {
        useVersion("1.5.30")
      }
    }
  }
}

tasks.register("clean", Delete::class) {
  delete(rootProject.buildDir)
}