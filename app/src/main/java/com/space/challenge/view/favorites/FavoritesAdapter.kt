package com.space.challenge.view.favorites

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.space.challenge.R
import com.space.challenge.databinding.ItemFavoriteStationBinding
import com.space.challenge.domain.model.Station
import com.space.challenge.utils.getDistance
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
    holder.binding.tvCapacity.text = String.format(
      "%s: %s", context?.getString(R.string.favorites_tv_item_station_capacity_text),
      item?.capacity.toString()
    )
    item?.coordinateX?.let { x ->
      item.coordinateY?.let { y ->
        holder.binding.tvEus.text = String.format(
          "%s: %.1f", context?.getString(R.string.favorites_tv_item_station_eus_text),
          getDistance(x, y, 0.0, 0.0)
        )
      }
    }

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