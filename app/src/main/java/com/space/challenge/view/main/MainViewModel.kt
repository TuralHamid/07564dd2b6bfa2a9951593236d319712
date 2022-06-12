package com.space.challenge.view.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.space.challenge.domain.interactors.main.DeleteAllStationsUseCase
import com.space.challenge.domain.interactors.main.GetApiStationsUseCase
import com.space.challenge.domain.interactors.main.InsertAllStationsUseCase
import com.space.challenge.domain.model.ResultState
import com.space.challenge.domain.model.Station
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  private val getApiStationsUseCase: GetApiStationsUseCase,
  private val insertAllStationsUseCase: InsertAllStationsUseCase,
  private val deleteAllStationsUseCase: DeleteAllStationsUseCase
) : ViewModel() {

  val stationsState = MutableLiveData<ResultState<List<Station?>?>>()
  val insertState = MutableLiveData<ResultState<Nothing>>()
  val deletStationsState = MutableLiveData<ResultState<Nothing>>()

  fun callGetStations() {
    viewModelScope.launch {
      getApiStationsUseCase.execute().collect {
        stationsState.value = it
      }
    }
  }

  fun callInsertAllStations(stations: List<Station>) {
    viewModelScope.launch {
      insertAllStationsUseCase.execute(stations).collect {
        insertState.value = it
      }
    }
  }

  fun callDeleteStations(stations: List<Station>) {
    viewModelScope.launch {
      deleteAllStationsUseCase.execute(stations).collect {
        deletStationsState.value = it
      }
    }
  }
}