package com.space.challenge.view.favorites

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.space.challenge.R
import com.space.challenge.databinding.ItemFavoriteStationBinding
import com.space.challenge.model.Station
import com.space.challenge.view.BaseAdapter

class FavoritesAdapter(
  context: Context?,
  private val favoriteStationClickListener: FavoriteStationClickListener
) : BaseAdapter<Station?, FavoritesAdapter.FavoritesViewHolder?>(context) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
    return FavoritesViewHolder(layoutInflater.inflate(R.layout.item_favorite_station, parent, false))
  }

  override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
    val item = getItem(position)
    item?.pos = position
    holder.binding.tvName.text = item?.name

    holder.binding.imvFav.setOnClickListener {
      favoriteStationClickListener.onFavoriteClicked(item)
    }

    if (item?.isFavorite == true) {
      holder.binding.imvFav.setImageResource(R.drawable.ic_favorites)
    } else {
      holder.binding.imvFav.setImageResource(R.drawable.ic_favorites_empty)
    }
  }

  interface FavoriteStationClickListener {
    fun onFavoriteClicked(station: Station?)
  }

  class FavoritesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var binding: ItemFavoriteStationBinding = ItemFavoriteStationBinding.bind(itemView)
  }
}