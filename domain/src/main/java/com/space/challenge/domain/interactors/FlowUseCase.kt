package com.space.challenge.domain.interactors

import com.space.challenge.domain.model.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class FlowUseCase<T> {

  suspend fun execute(): Flow<ResultState<T?>> {
    val response = buildResponse()
    return try {
      flow<ResultState<T?>> {
        emit(ResultState.Success(response))
      }
    } catch (e: Throwable) {
      flow<ResultState<T>> {
        emit(ResultState.Error(e))
      }
    }
  }

  abstract suspend fun buildResponse(): T?
}