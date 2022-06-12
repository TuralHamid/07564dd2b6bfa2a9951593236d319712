package com.space.challenge.view.favorites

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.space.challenge.domain.interactors.favorites.DeleteFavoriteUseCase
import com.space.challenge.domain.interactors.favorites.GetFavoritesUseCase
import com.space.challenge.domain.model.FavoriteStation
import com.space.challenge.domain.model.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
  private val getFavoritesUseCase: GetFavoritesUseCase,
  private val deleteFavoriteUseCase: DeleteFavoriteUseCase
) : ViewModel() {

  val favoritesState = MutableLiveData<ResultState<List<FavoriteStation>?>>()
  val deleteFavState = MutableLiveData<ResultState<Nothing>>()

  fun callGetFavStations() {
    viewModelScope.launch {
      getFavoritesUseCase.execute().collect {
        favoritesState.value = it
      }
    }
  }

  fun callDeleteFavStation(favoriteStation: FavoriteStation) {
    viewModelScope.launch {
      deleteFavoriteUseCase.execute(favoriteStation).collect {
        deleteFavState.value = it
      }
    }
  }
}