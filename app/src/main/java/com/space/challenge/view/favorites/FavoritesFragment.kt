package com.space.challenge.view.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.space.challenge.databinding.FragmentFavoritesBinding
import com.space.challenge.view.BaseFragment

class FavoritesFragment : BaseFragment() {
  private var binding: FragmentFavoritesBinding? = null


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
}