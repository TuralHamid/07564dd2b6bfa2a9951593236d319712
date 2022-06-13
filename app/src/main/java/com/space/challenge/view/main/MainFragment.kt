package com.space.challenge.view.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding
import com.space.challenge.R
import com.space.challenge.databinding.FragmentMainBinding
import com.space.challenge.domain.model.ResultState
import com.space.challenge.domain.model.Station
import com.space.challenge.model.SpaceShip
import com.space.challenge.utils.getDistance
import com.space.challenge.view.BaseFragment
import com.space.challenge.view.stations.StationsFragment.Companion.ARG_SPACE_SHIP
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment(), SeekBar.OnSeekBarChangeListener {
  private var binding: FragmentMainBinding? = null
  private val viewModel: MainViewModel by viewModels()
  private var stationResponse: List<Station?>? = listOf()
  private var name: String? = null
  private var durability: Int = 0
  private var speed: Int = 0
  private var capacity: Int = 0

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setListeners()
    setViewParameters()
    setObservers()
    viewModel.callGetStations()
  }

  private fun setObservers() {
    viewModel.stationsState.observe(viewLifecycleOwner) {
      when (it) {
        is ResultState.Error -> {
          Toast.makeText(context, it.exception.message, Toast.LENGTH_SHORT).show()
        }
        is ResultState.Success<List<Station?>?> -> {
          stationResponse = it.data
          viewModel.callDeleteStations(listOf())
          stationResponse?.forEach { station ->
            station?.coordinateX?.let { x ->
              station.coordinateY?.let { y ->
                station.eus = getDistance(x, y, 0.0, 0.0)
              }
            }
          }
          viewModel.callInsertAllStations(stationResponse as List<Station>)
        }
      }
    }
  }

  private fun setViewParameters() {
    binding?.skbDurability?.max = FEATURE_MAX_POINT - 2
    binding?.skbSpeed?.max = FEATURE_MAX_POINT - 2
    binding?.skbCapacity?.max = FEATURE_MAX_POINT - 2
  }

  private fun setListeners() {
    binding?.btnContinue?.setOnClickListener {
      if (isInputValid()) {
        navController.navigate(
          R.id.act_btnContinue_to_bnvNavigation,
          bundleOf(
            ARG_SPACE_SHIP to SpaceShip(name, durability, speed, capacity)
          )
        )
      }
    }

    binding?.skbDurability?.setOnSeekBarChangeListener(this)
    binding?.skbSpeed?.setOnSeekBarChangeListener(this)
    binding?.skbCapacity?.setOnSeekBarChangeListener(this)

    binding?.edtName?.addTextChangedListener(object : TextWatcher {
      override fun afterTextChanged(s: Editable) {}

      override fun beforeTextChanged(
        s: CharSequence, start: Int,
        count: Int, after: Int
      ) {
      }

      override fun onTextChanged(
        s: CharSequence, start: Int,
        before: Int, count: Int
      ) {
        name = s.toString()
      }
    })
  }

  private fun isInputValid(): Boolean {
    if (name.isNullOrEmpty()) {
      Toast.makeText(context, R.string.main_name_not_valid_error_toast_text, Toast.LENGTH_SHORT).show()
      return false
    }
    if (durability < 1) {
      Toast.makeText(context, R.string.main_durability_not_valid_error_toast_text, Toast.LENGTH_SHORT).show()
      return false
    }
    if (speed < 1) {
      Toast.makeText(context, R.string.main_speed_not_valid_error_toast_text, Toast.LENGTH_SHORT).show()
      return false
    }
    if (capacity < 1) {
      Toast.makeText(context, R.string.main_capacity_not_valid_error_toast_text, Toast.LENGTH_SHORT).show()
      return false
    }
    return true
  }

  private fun isPointHigherThanLimit(): Boolean {
    return durability + speed + capacity > FEATURE_MAX_POINT
  }

  override fun onProgressChanged(seekbar: SeekBar?, progress: Int, fromUser: Boolean) {
    when (seekbar?.id) {
      binding?.skbDurability?.id -> {
        durability = progress
        if (isPointHigherThanLimit()) {
          seekbar?.progress = FEATURE_MAX_POINT - speed - capacity
        }
      }
      binding?.skbSpeed?.id -> {
        speed = progress
        if (isPointHigherThanLimit()) {
          seekbar?.progress = FEATURE_MAX_POINT - durability - capacity
        }
      }
      binding?.skbCapacity?.id -> {
        capacity = progress
        if (isPointHigherThanLimit()) {
          seekbar?.progress = FEATURE_MAX_POINT - durability - speed
        }
      }
    }
    binding?.tvPointsValue?.text = (FEATURE_MAX_POINT - durability - speed - capacity).toString()
  }

  override fun onStartTrackingTouch(seekbar: SeekBar?) {
  }

  override fun onStopTrackingTouch(seekbar: SeekBar?) {
  }

  override fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): ViewBinding? {
    if (binding == null) {
      binding = FragmentMainBinding.inflate(inflater, container, false)
    }
    return binding
  }

  override fun destroyViewBinding() {
    binding = null
  }

  override fun showBnv(): Boolean {
    return false
  }

  companion object {
    private const val FEATURE_MAX_POINT: Int = 15
  }
}