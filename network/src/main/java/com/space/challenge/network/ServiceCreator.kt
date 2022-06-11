package com.space.challenge.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.space.challenge.network.interceptors.DefaultHeaderInterceptor
import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient.Builder
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class ServiceCreator(
  baseUrl: String,
  defaultHeaderInterceptor: DefaultHeaderInterceptor,
  moshi: Moshi
) {
  private val retrofit: Retrofit
  fun <S> createService(serviceClass: Class<S>): S {
    return retrofit.create(serviceClass)
  }

  init {
    val builder: Builder = Builder()
      .writeTimeout(60, TimeUnit.SECONDS)
      .readTimeout(60, TimeUnit.SECONDS)
      .connectTimeout(60, TimeUnit.SECONDS)
      .addInterceptor(defaultHeaderInterceptor as Interceptor)
    if (BuildConfig.DEBUG) {
      builder.addInterceptor(
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
      )
    }

    val retrofitBuilder = Retrofit.Builder()
      .baseUrl(baseUrl)
      .addConverterFactory(MoshiConverterFactory.create(moshi))
      .client(builder.build())
      .addCallAdapterFactory(CoroutineCallAdapterFactory())

    retrofit = retrofitBuilder.build()
  }
}
