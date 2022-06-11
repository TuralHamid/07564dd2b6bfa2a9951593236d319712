object Dependency {

  object LibVersions {
    const val coreLibraryDesugaring = "1.1.5"

    const val appcompat = "1.4.2"
    const val constraintLayout = "2.1.0"
    const val material = "1.6.1"
    const val multiDex = "2.0.0"
    const val coreKtx = "1.7.0"
    const val fragmentKtx = "1.3.6"
    const val recyclerView = "1.2.1"
    const val retrofit = "2.9.0"
    const val moshi = "1.9.3"
    const val timber = "4.7.1"
    const val dagger = "2.38.1"
    const val navigation = "2.3.5"

    const val junit = "4.13.2"
    const val junitExt = "1.1.3"
    const val espresso = "3.4.0"
    const val truth = "1.0.1"
  }


  object Desugaring {
    const val coreLibraryDesugaring = "com.android.tools:desugar_jdk_libs:${LibVersions.coreLibraryDesugaring}"
  }

  object Library {
    const val appcompat = "androidx.appcompat:appcompat:${LibVersions.appcompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${LibVersions.constraintLayout}"
    const val material = "com.google.android.material:material:${LibVersions.material}"
    const val multiDex = "androidx.multidex:multidex:${LibVersions.multiDex}"
    const val coreKtx = "androidx.core:core-ktx:${LibVersions.coreKtx}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${LibVersions.fragmentKtx}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${LibVersions.recyclerView}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${LibVersions.retrofit}"
    const val retrofitMoshiConverter = "com.squareup.retrofit2:converter-moshi:${LibVersions.retrofit}"
    const val retrofitAdapter = "com.squareup.retrofit2:adapter-rxjava3:${LibVersions.retrofit}"
    const val moshi = "com.squareup.moshi:moshi:${LibVersions.moshi}"
    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${LibVersions.moshi}"
    const val timber = "com.jakewharton.timber:timber:${LibVersions.timber}"
    const val daggerHiltAndroid = "com.google.dagger:hilt-android:${LibVersions.dagger}"
    const val daggerHiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${LibVersions.dagger}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${LibVersions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${LibVersions.navigation}"
  }

  object TestLibrary {
    const val junit = "junit:junit:${LibVersions.junit}"
    const val junitExt = "androidx.test.ext:junit:${LibVersions.junitExt}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${LibVersions.espresso}"
    const val truth = "com.google.truth:truth:${LibVersions.truth}"
  }

  val MODULE_UI_IMPL_DEPS = listOf(
    Library.appcompat,
    Library.constraintLayout,
    Library.material,
    Library.multiDex,
    Library.coreKtx,
    Library.fragmentKtx,
    Library.recyclerView,
    Library.retrofit,
    Library.moshi,
    Library.moshiKotlin,
    Library.timber,
    Library.daggerHiltAndroid,
    Library.navigationFragment,
    Library.navigationUi
  )

  val MODULE_UI_KAPT_DEPS = listOf(
    Library.daggerHiltAndroidCompiler
  )

  val MODULE_CACHE_IMPL_DEPS = listOf(
    Library.coreKtx,
    Library.moshi,
    Library.moshiKotlin,
  )

  val MODULE_DATA_IMPL_DEPS = listOf(
    Library.coreKtx
  )

  val MODULE_DOMAIN_IMPL_DEPS = listOf(
    Library.coreKtx,
    Library.moshi,
    Library.moshiKotlin
  )

  val MODULE_NETWORK_IMPL_DEPS = listOf(
    Library.coreKtx,
    Library.retrofit,
    Library.retrofitAdapter,
    Library.retrofitMoshiConverter,
    Library.moshi,
    Library.moshiKotlin
  )


  val MODULE_UI_ANDROID_TEST_DEPS = listOf(
    TestLibrary.junit,
    TestLibrary.junitExt,
    TestLibrary.espressoCore,
    TestLibrary.truth
  )

  val MODULE_UI_TEST_DEPS = listOf(
    TestLibrary.junit,
    TestLibrary.junitExt,
    TestLibrary.espressoCore,
    TestLibrary.truth
  )

  val MODULE_CACHE_TEST_DEPS = listOf(
    TestLibrary.junit
  )

  val MODULE_DATA_TEST_DEPS = listOf(
    TestLibrary.junit
  )

  val MODULE_DOMAIN_TEST_DEPS = listOf(
    TestLibrary.junit
  )

  val MODULE_NETWORK_TEST_DEPS = listOf(
    TestLibrary.junit
  )
}