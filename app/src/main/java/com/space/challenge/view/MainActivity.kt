package com.space.challenge.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.space.challenge.R
import com.space.challenge.databinding.ActivityMainBinding


class MainActivity : BaseActivity() {
  private var binding: ActivityMainBinding? = null
  lateinit var navController: NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setupNavigation()
  }

  private fun setupNavigation() {
    navController = findNavController(R.id.nav_host_fragment)
    binding?.bnv?.setupWithNavController(navController)
  }

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