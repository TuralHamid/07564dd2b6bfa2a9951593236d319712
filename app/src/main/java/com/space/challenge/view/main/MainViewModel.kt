package com.space.challenge.view.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.space.challenge.domain.interactors.StationsUseCase
import com.space.challenge.domain.model.ResultState
import com.space.challenge.domain.model.Station
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  private val stationsUseCase: StationsUseCase
) : ViewModel() {

  val stationsState = MutableLiveData<ResultState<List<Station?>?>>()

  fun callGetStations() {
    viewModelScope.launch {
      stationsUseCase.execute().collect {
        stationsState.value = it
      }
    }
  }
}