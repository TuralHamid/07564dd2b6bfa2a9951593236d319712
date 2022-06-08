plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
}

android {
  compileSdk = Config.compileSdkVersion

  defaultConfig {
    minSdk = Config.minSdkVersion
    targetSdk = Config.targetSdkVersion
    multiDexEnabled = true
    testInstrumentationRunner = Config.androidTestInstrumentation
    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    debug {
      isMinifyEnabled = false
      isShrinkResources = false
    }
    release {
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = Config.jvmTargetVersion
  }
}

dependencies {
  coreLibraryDesugaring(Dependency.Desugaring.coreLibraryDesugaring)

  implementation(project(":data"))

  for (library in Dependency.MODULE_CACHE_IMPL_DEPS) {
    implementation(library)
  }

  for (library in Dependency.MODULE_CACHE_TEST_DEPS) {
    testImplementation(library)
  }
}