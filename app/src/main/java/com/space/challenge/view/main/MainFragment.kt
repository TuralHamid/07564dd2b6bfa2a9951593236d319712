package com.space.challenge.view.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.space.challenge.databinding.FragmentMainBinding
import com.space.challenge.view.BaseFragment

class MainFragment : BaseFragment() {
  private var binding: FragmentMainBinding? = null


  override fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): ViewBinding? {
    if (binding == null) {
      binding = FragmentMainBinding.inflate(inflater, container, false)
    }
    return binding
  }

  override fun destroyViewBinding() {
    binding = null
  }
}