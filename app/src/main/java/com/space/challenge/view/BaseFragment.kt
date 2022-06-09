package com.space.challenge.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseFragment : Fragment() {

  lateinit var navController: NavController

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val binding = createViewBinding(inflater, container)
    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    navController = Navigation.findNavController(view)
    navController.addOnDestinationChangedListener { controller, destination, arguments ->
      when (showBnv()) {
        true -> getMainActivity()?.showBottomNav()
        false -> getMainActivity()?.hideBottomNav()
      }
    }
  }


  override fun onDestroyView() {
    super.onDestroyView()
    destroyViewBinding()
  }

  abstract fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): ViewBinding?

  abstract fun destroyViewBinding()

  abstract fun showBnv(): Boolean

  protected fun getBaseActivity(): BaseActivity? {
    return activity as BaseActivity?
  }

  fun getMainActivity(): MainActivity? {
    return activity as MainActivity?
  }
}