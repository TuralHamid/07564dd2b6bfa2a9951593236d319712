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
    const val retrofitCoroutinesAdapter = "0.9.2"
    const val coroutines = "1.5.2"
    const val room = "2.4.2"
    const val okHttp = "4.9.0"
    const val moshi = "1.9.3"
    const val timber = "4.7.1"
    const val dagger = "2.38.1"
    const val javaxInject = "1"
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
    const val okHttp = "com.squareup.okhttp3:okhttp:${LibVersions.okHttp}"
    const val okHttpLogger = "com.squareup.okhttp3:logging-interceptor:${LibVersions.okHttp}"
    const val retrofitAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${LibVersions.retrofitCoroutinesAdapter}"

    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${LibVersions.coroutines}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${LibVersions.coroutines}"

    const val room = "androidx.room:room-runtime:${LibVersions.room}"
    const val roomKtx = "androidx.room:room-ktx:${LibVersions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${LibVersions.room}"

    const val moshi = "com.squareup.moshi:moshi:${LibVersions.moshi}"
    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${LibVersions.moshi}"

    const val timber = "com.jakewharton.timber:timber:${LibVersions.timber}"
    const val daggerHiltAndroid = "com.google.dagger:hilt-android:${LibVersions.dagger}"
    const val daggerHiltCompiler = "com.google.dagger:hilt-compiler:${LibVersions.dagger}"
    const val daggerHiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${LibVersions.dagger}"
    const val javaxInject = "javax.inject:javax.inject:${LibVersions.javaxInject}"

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
    Library.coroutinesAndroid,
    Library.coroutinesCore,
    Library.room,
    Library.roomKtx,
    Library.javaxInject,
    Library.moshi,
    Library.moshiKotlin,
    Library.timber,
    Library.daggerHiltAndroid,
    Library.navigationFragment,
    Library.navigationUi
  )

  val MODULE_CACHE_IMPL_DEPS = listOf(
    Library.coreKtx,
    Library.coroutinesAndroid,
    Library.coroutinesCore,
    Library.room,
    Library.roomKtx,
    Library.javaxInject,
    Library.moshi,
    Library.moshiKotlin,
  )

  val MODULE_DATA_IMPL_DEPS = listOf(
    Library.coreKtx,
    Library.coroutinesAndroid,
    Library.coroutinesCore,
    Library.room,
    Library.roomKtx,
    Library.javaxInject,
    Library.okHttp
  )

  val MODULE_DOMAIN_IMPL_DEPS = listOf(
    Library.coreKtx,
    Library.coroutinesAndroid,
    Library.coroutinesCore,
    Library.room,
    Library.roomKtx,
    Library.javaxInject,
    Library.moshi,
    Library.moshiKotlin
  )

  val MODULE_NETWORK_IMPL_DEPS = listOf(
    Library.coreKtx,
    Library.javaxInject,
    Library.retrofit,
    Library.retrofitAdapter,
    Library.room,
    Library.roomKtx,
    Library.coroutinesAndroid,
    Library.coroutinesCore,
    Library.retrofitMoshiConverter,
    Library.okHttp,
    Library.okHttpLogger,
    Library.moshi,
    Library.moshiKotlin
  )

  val MODULE_UI_KAPT_DEPS = listOf(
    Library.daggerHiltCompiler,
    Library.daggerHiltAndroidCompiler,
    Library.roomCompiler
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