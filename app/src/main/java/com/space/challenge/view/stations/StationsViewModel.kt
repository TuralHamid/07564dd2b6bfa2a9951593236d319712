package com.space.challenge.view.stations

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.space.challenge.domain.interactors.stations.GetLocalStationsUseCase
import com.space.challenge.domain.interactors.stations.UpdateStationUseCase
import com.space.challenge.domain.model.ResultState
import com.space.challenge.domain.model.Station
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StationsViewModel @Inject constructor(
  private val getLocalStationsUseCase: GetLocalStationsUseCase,
  private val updateStationUseCase: UpdateStationUseCase
) : ViewModel() {

  val getLocalStationsState = MutableLiveData<ResultState<List<Station>?>>()
  val updateFavState = MutableLiveData<ResultState<Nothing>>()

  fun callGetLocalStations() {
    viewModelScope.launch {
      getLocalStationsUseCase.execute().collect {
        getLocalStationsState.value = it
      }
    }
  }

  fun callUpdateStation(station: Station) {
    viewModelScope.launch {
      updateStationUseCase.execute(station).collect {
        updateFavState.value = it
      }
    }
  }
}