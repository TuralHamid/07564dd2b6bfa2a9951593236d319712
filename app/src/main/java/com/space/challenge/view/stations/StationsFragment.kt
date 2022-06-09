package com.space.challenge.view.stations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.space.challenge.databinding.FragmentStationsBinding
import com.space.challenge.view.BaseFragment


class StationsFragment : BaseFragment() {
  private var binding: FragmentStationsBinding? = null


  override fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): ViewBinding? {
    if (binding == null) {
      binding = FragmentStationsBinding.inflate(inflater, container, false)
    }
    return binding
  }

  override fun destroyViewBinding() {
    binding = null
  }
}