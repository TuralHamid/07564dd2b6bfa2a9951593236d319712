package com.space.challenge.domain.interactors

import com.space.challenge.domain.model.ResultState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class FlowUseCase<T> {

  suspend fun execute(): Flow<ResultState<T>> {
    val answer = buildFlow()
    return try {
      return flow<ResultState<T>> {
        ResultState.Success(answer)
      }.flowOn(Dispatchers.IO)
    } catch (e: Throwable) {
      flow<ResultState<T>> {
        emit(ResultState.Error(e))
      }.flowOn(Dispatchers.IO)
    }
  }

  abstract suspend fun buildFlow(): T?
}