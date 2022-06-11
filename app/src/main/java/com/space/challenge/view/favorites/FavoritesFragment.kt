package com.space.challenge.view.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.space.challenge.databinding.FragmentFavoritesBinding
import com.space.challenge.model.Station
import com.space.challenge.utils.filterFavoriteStations
import com.space.challenge.utils.hideView
import com.space.challenge.utils.showView
import com.space.challenge.view.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : BaseFragment(), FavoritesAdapter.FavoriteStationClickListener {
  private var binding: FragmentFavoritesBinding? = null
  private lateinit var favoritesAdapter: FavoritesAdapter
  private var currentStationList: List<Station> = listOf()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initAdapter()
  }

  private fun initAdapter() {
    favoritesAdapter = FavoritesAdapter(context, this)
    binding?.let {
      it.rcvFavorites.setHasFixedSize(true)
      it.rcvFavorites.layoutManager = LinearLayoutManager(context)
      it.rcvFavorites.adapter = favoritesAdapter
    }


    currentStationList = listOf(
      //TODO dummy data
      Station("Mars", 2.0, 3.0, 2000, 800, 100).apply {
        isFavorite = true
      },
      Station("Mercury", 2.0, 3.0, 1500, 900, 100),
      Station("Saturn", 2.0, 3.0, 900, 300, 100).apply {
        isFavorite = true
      }
    )

    favoritesAdapter.setItems(checkFavEmpty().toMutableList())
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
      favoritesAdapter.deleteItemAndUpdate(station.pos)
    }
    checkFavEmpty()
  }
}