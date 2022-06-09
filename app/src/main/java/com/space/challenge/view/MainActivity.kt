package com.space.challenge.view

import android.view.LayoutInflater
import com.space.challenge.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
  private var binding: ActivityMainBinding? = null


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