package com.space.challenge.domain.interactors.main

import com.space.challenge.domain.interactors.FlowUseCase
import com.space.challenge.domain.model.Station
import com.space.challenge.domain.repository.MainRepository
import javax.inject.Inject

class GetApiStationsUseCase @Inject constructor(
  private val mainRepository: MainRepository
) : FlowUseCase<List<Station?>>() {

  override suspend fun buildResponse(): List<Station?> {
    return mainRepository.callGetStations()
  }
}