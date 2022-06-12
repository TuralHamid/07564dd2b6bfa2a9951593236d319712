package com.space.challenge.view.favorites

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
class FavoritesViewModel @Inject constructor(
  private val getLocalStationsUseCase: GetLocalStationsUseCase,
  private val updateStationUseCase: UpdateStationUseCase
) : ViewModel() {

  val localStationsState = MutableLiveData<ResultState<List<Station>?>>()
  val updateFavState = MutableLiveData<ResultState<Nothing>>()

  fun callGetLocalStations() {
    viewModelScope.launch {
      getLocalStationsUseCase.execute().collect {
        localStationsState.value = it
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