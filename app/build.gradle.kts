plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("kotlin-android")
  id("kotlin-kapt")
  id("kotlin-parcelize")
}

android {
  compileSdk = Config.compileSdkVersion

  defaultConfig {
    applicationId = Config.applicationId
    minSdk = Config.minSdkVersion
    targetSdk = Config.targetSdkVersion
    versionCode = 1
    versionName = "1.0.0"
    multiDexEnabled = true
    testInstrumentationRunner = Config.androidTestInstrumentation
  }

  buildTypes {
    debug {
      applicationIdSuffix = ".debug"
      resValue("string", Config.appNameLabel, Config.appNameDev)
      isDebuggable = true
      isMinifyEnabled = false
      isShrinkResources = false
    }
    release {
      applicationIdSuffix = ".prod"
      resValue("string", Config.appNameLabel, Config.appName)
      isMinifyEnabled = true
      isShrinkResources = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }

  flavorDimensions.add("mode")

  productFlavors {
    create("dev") {
      dimension = "mode"
      buildConfigField("String", Config.baseUrlLabel, "\"${Config.devApiUrl}\"")
    }

    create("prod") {
      dimension = "mode"
      buildConfigField("String", Config.baseUrlLabel, "\"${Config.prodApiUrl}\"")
    }
  }

  compileOptions {
    isCoreLibraryDesugaringEnabled = true
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
  implementation(project(":cache"))
  implementation(project(":network"))

  for (library in Dependency.MODULE_UI_IMPL_DEPS) {
    implementation(library)
  }

  for (library in Dependency.MODULE_UI_KAPT_DEPS) {
    kapt(library)
  }

  for (library in Dependency.MODULE_UI_ANDROID_TEST_DEPS) {
    androidTestImplementation(library)
  }

  for (library in Dependency.MODULE_UI_TEST_DEPS) {
    testImplementation(library)
  }
}