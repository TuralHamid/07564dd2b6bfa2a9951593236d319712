package com.space.challenge.domain.interactors

import com.space.challenge.domain.model.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class CompleteUseCase<S> {

  suspend fun execute(param: S): Flow<ResultState<Nothing>> {
    val response = buildResponse(param)
    return try {
      flow<ResultState<Nothing>> {
        emit(ResultState.Complete)
      }
    } catch (e: Throwable) {
      flow<ResultState<Nothing>> {
        emit(ResultState.Error(e))
      }
    }
  }

  abstract suspend fun buildResponse(param: S)
}