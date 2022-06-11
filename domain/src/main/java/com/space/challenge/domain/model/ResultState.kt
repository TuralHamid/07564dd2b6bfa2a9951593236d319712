package com.space.challenge.domain.model

sealed class ResultState<out R> {


  data class Success<out T>(val data: T) : ResultState<T>()
  data class Error<out T>(val exception: Throwable) : ResultState<T>()
  object Loading : ResultState<Nothing>()
  object Complete : ResultState<Nothing>()
  object Handled : ResultState<Nothing>()

  override fun toString(): String {
    return when (this) {
      is Success<*> -> "Success[data=$data]"
      is Error -> "Error[exception=$exception]"
      Loading -> "Loading"
      Complete -> "Complete"
      Handled -> "Handled"
    }
  }
}

val ResultState<*>.succeeded
  get() = (this is ResultState.Success && data != null) || this is ResultState.Complete

val ResultState<*>.failed
  get() = this is ResultState.Error

val ResultState<*>.finished
  get() = this !is ResultState.Loading