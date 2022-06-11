package com.space.challenge.network.interceptors

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class DefaultHeaderInterceptor : Interceptor {
  @Throws(IOException::class)
  override fun intercept(chain: Interceptor.Chain): Response {
    var request = chain.request()
    val requestBuilder = request.newBuilder()
      .addHeader(
        CONTENT_TYPE_LABEL,
        CONTENT_TYPE_VALUE
      )
      .addHeader(
        ACCEPT_CHARSET_LABEL,
        ACCEPT_CHARSET_VALUE
      )
    request = requestBuilder.method(request.method, request.body)
      .build()
    val response: Response?
    try {
      response = chain.proceed(request)
    } catch (e: Exception) {
      throw PaycellRetrofitException(request, e)
    }
    return response.newBuilder().build()
  }

  companion object {
    private const val CONTENT_TYPE_LABEL = "Content-Type"
    private const val CONTENT_TYPE_VALUE = "application/json"
    private const val ACCEPT_CHARSET_LABEL = "Accept-Charset"
    private const val ACCEPT_CHARSET_VALUE = "utf-8"
  }

  class PaycellRetrofitException(val request: Request, val throwable: Throwable) : IOException()
}