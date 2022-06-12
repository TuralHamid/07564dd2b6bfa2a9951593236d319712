package com.space.challenge.view.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.space.challenge.databinding.FragmentFavoritesBinding
import com.space.challenge.domain.model.ResultState
import com.space.challenge.domain.model.Station
import com.space.challenge.utils.filterFavoriteStations
import com.space.challenge.utils.hideView
import com.space.challenge.utils.showView
import com.space.challenge.utils.sortStationsByName
import com.space.challenge.view.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : BaseFragment(), FavoritesAdapter.FavoriteStationClickListener {
  private var binding: FragmentFavoritesBinding? = null
  private lateinit var favoritesAdapter: FavoritesAdapter
  private val viewModel: FavoritesViewModel by viewModels()
  private var currentStationList: List<Station> = listOf()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setObservers()
    initAdapter()
    viewModel.callGetLocalStations()
  }

  private fun setObservers() {
    viewModel.localStationsState.observe(viewLifecycleOwner) {
      when (it) {
        is ResultState.Error -> {
          Toast.makeText(context, it.exception.message, Toast.LENGTH_SHORT).show()
        }
        is ResultState.Success<List<Station?>?> -> {
          currentStationList = it.data?.filterFavoriteStations() as List<Station>
          favoritesAdapter.setItems(checkFavEmpty().sortStationsByName().toMutableList())
        }
      }
    }
  }

  private fun initAdapter() {
    favoritesAdapter = FavoritesAdapter(context, this)
    binding?.let {
      it.rcvFavorites.setHasFixedSize(true)
      it.rcvFavorites.layoutManager = LinearLayoutManager(context)
      it.rcvFavorites.adapter = favoritesAdapter
    }
  }

  private fun checkFavEmpty(): List<Station> {
    val favList = currentStationList.filterFavoriteStations()
    if (favList.isEmpty()) {
      binding?.tvEmptyFavorites?.showView()
    } else {
      binding?.tvEmptyFavorites?.hideView()
    }
    return favList
  }

  override fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): ViewBinding? {
    if (binding == null) {
      binding = FragmentFavoritesBinding.inflate(inflater, container, false)
    }
    return binding
  }

  override fun destroyViewBinding() {
    binding = null
  }

  override fun showBnv(): Boolean {
    return true
  }

  override fun onFavoriteClicked(station: Station?) {
    station?.let {
      favoritesAdapter.getItem(station.pos)?.isFavorite = false
      favoritesAdapter.getItem(station.pos)?.let {
        viewModel.callUpdateStation(it)
      }
      favoritesAdapter.deleteItemAndUpdate(station.pos)
    }
    checkFavEmpty()
  }
}