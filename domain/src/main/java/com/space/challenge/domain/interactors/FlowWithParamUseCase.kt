package com.space.challenge.domain.interactors

import com.space.challenge.domain.model.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


abstract class FlowWithParamUseCase<S, T> {

  suspend fun execute(param: S): Flow<ResultState<T?>> {
    val response = buildResponse(param)
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

  abstract suspend fun buildResponse(param: S): T?
}