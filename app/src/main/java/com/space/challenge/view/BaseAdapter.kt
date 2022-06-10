package com.space.challenge.view

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T, V : RecyclerView.ViewHolder?>(@JvmField val context: Context?) :
  RecyclerView.Adapter<V>() {
  @JvmField
  protected var layoutInflater: LayoutInflater =
    context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

  @JvmField
  protected var itemList: MutableList<T>? = null

  protected var recyclerView: RecyclerView? = null

  override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
    super.onAttachedToRecyclerView(recyclerView)
    this.recyclerView = recyclerView
  }

  override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
    super.onDetachedFromRecyclerView(recyclerView)
    this.recyclerView = recyclerView
  }

  fun getItem(position: Int): T {
    return itemList!![position]
  }

  fun getItems(): MutableList<T>? {
    return itemList
  }

  fun setItems(itemList: MutableList<T>?) {
    this.itemList = itemList
    notifyDataSetChanged()
  }

  override fun getItemCount(): Int {
    return itemList?.size ?: 0
  }
}