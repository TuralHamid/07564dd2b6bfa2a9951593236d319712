package com.space.challenge.domain.interactors.main

import com.space.challenge.domain.interactors.CompleteUseCase
import com.space.challenge.domain.model.Station
import com.space.challenge.domain.repository.MainRepository
import javax.inject.Inject

class DeleteAllStationsUseCase @Inject constructor(
  private val mainRepository: MainRepository
) : CompleteUseCase<List<Station>>() {
  override suspend fun buildResponse(param: List<Station>) {
    return mainRepository.callDeleteAllStation(param)
  }
}