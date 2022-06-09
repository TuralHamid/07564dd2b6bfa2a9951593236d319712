package com.space.challenge.view

import android.view.LayoutInflater
import android.view.View
import com.space.challenge.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
  private var binding: ActivityMainBinding? = null

  fun showBottomNav() {
    binding?.bnv?.visibility = View.VISIBLE
  }

  fun hideBottomNav() {
    binding?.bnv?.visibility = View.GONE
  }

  override fun createViewBinding(inflater: LayoutInflater): ActivityMainBinding? {
    if (binding == null) {
      binding = ActivityMainBinding.inflate(inflater)
    }
    return binding
  }

  override fun destroyViewBinding() {
    binding = null
  }

}