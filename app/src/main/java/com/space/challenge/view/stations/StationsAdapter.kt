package com.space.challenge.view.stations

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.space.challenge.R
import com.space.challenge.databinding.ItemStationBinding
import com.space.challenge.model.Station
import com.space.challenge.view.BaseAdapter

class StationsAdapter(
  context: Context?,
  private val stationClickListener: StationClickListener
) : BaseAdapter<Station?, StationsAdapter.StationsViewHolder?>(context) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationsViewHolder {
    return StationsViewHolder(layoutInflater.inflate(R.layout.item_station, parent, false))
  }

  override fun onBindViewHolder(holder: StationsViewHolder, position: Int) {
    val item = getItem(position)
    item?.pos = position
    context?.let {
      holder.binding.tvCoordinateXTitle.text = String.format(context.getString(R.string.stations_tv_item_station_coordinate_x_text), item?.coordinateX)
      holder.binding.tvCoordinateYTitle.text = String.format(context.getString(R.string.stations_tv_item_station_coordinate_y_text), item?.coordinateY)
      holder.binding.tvCapacityTitle.text = String.format(context.getString(R.string.stations_tv_item_station_capacity_text), item?.capacity)
      holder.binding.tvStockTitle.text = String.format(context.getString(R.string.stations_tv_item_station_stock_text), item?.stock)
      holder.binding.tvNeedTitle.text = String.format(context.getString(R.string.stations_tv_item_station_need_text), item?.need)
      holder.binding.tvName.text = item?.name
    }

    holder.binding.btnTravel.setOnClickListener {
      stationClickListener.onTravelClicked(item)
    }

    holder.binding.imvFav.setOnClickListener {
      stationClickListener.onFavoriteClicked(item)
    }

    if (item?.isFavorite == true) {
      holder.binding.imvFav.setImageResource(R.drawable.ic_favorites)
    } else {
      holder.binding.imvFav.setImageResource(R.drawable.ic_favorites_empty)
    }
  }

  interface StationClickListener {
    fun onTravelClicked(station: Station?)
    fun onFavoriteClicked(station: Station?)
  }

  class StationsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var binding: ItemStationBinding = ItemStationBinding.bind(itemView)
  }
}