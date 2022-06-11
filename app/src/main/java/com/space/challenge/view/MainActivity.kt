package com.space.challenge.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
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
    binding?.bnv?.setOnItemSelectedListener { item ->
      navController.navigate(
        item.itemId
      )
      true
    }
  }

  override fun onBackPressed() {
    if (navController.currentDestination?.id?.equals(R.id.favoritesFragment) == true) {
      binding?.bnv?.selectedItemId = R.id.act_favoritesFragment_to_stationsFragment
    } else {
      super.onBackPressed()
    }
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