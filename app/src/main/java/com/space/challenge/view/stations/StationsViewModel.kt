package com.space.challenge.view.stations

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.space.challenge.domain.interactors.favorites.DeleteFavoriteUseCase
import com.space.challenge.domain.interactors.stations.GetFavStationsUseCase
import com.space.challenge.domain.interactors.stations.GetLocalStationsUseCase
import com.space.challenge.domain.interactors.stations.InsertFavoriteUseCase
import com.space.challenge.domain.interactors.stations.UpdateStationUseCase
import com.space.challenge.domain.model.FavoriteStation
import com.space.challenge.domain.model.ResultState
import com.space.challenge.domain.model.Station
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StationsViewModel @Inject constructor(
  private val deleteFavoriteUseCase: DeleteFavoriteUseCase,
  private val getFavStationsUseCase: GetFavStationsUseCase,
  private val getLocalStationsUseCase: GetLocalStationsUseCase,
  private val insertFavoriteUseCase: InsertFavoriteUseCase,
  private val updateStationUseCase: UpdateStationUseCase
) : ViewModel() {

  val deleteFavState = MutableLiveData<ResultState<Nothing>>()
  val getFavState = MutableLiveData<ResultState<List<FavoriteStation>?>>()
  val getLocalStationsState = MutableLiveData<ResultState<List<Station>?>>()
  val insertFavState = MutableLiveData<ResultState<Nothing>>()
  val updateFavState = MutableLiveData<ResultState<Nothing>>()

  fun callDeleteFavStation(favoriteStation: FavoriteStation) {
    viewModelScope.launch {
      deleteFavoriteUseCase.execute(favoriteStation).collect {
        deleteFavState.value = it
      }
    }
  }

  fun callGetFavStations() {
    viewModelScope.launch {
      getFavStationsUseCase.execute().collect {
        getFavState.value = it
      }
    }
  }

  fun callGetLocalStations() {
    viewModelScope.launch {
      getLocalStationsUseCase.execute().collect {
        getLocalStationsState.value = it
      }
    }
  }

  fun callInsertFavorite(favoriteStation: FavoriteStation) {
    viewModelScope.launch {
      insertFavoriteUseCase.execute(favoriteStation).collect {
        insertFavState.value = it
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