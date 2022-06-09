package com.space.challenge.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.space.challenge.R
import com.space.challenge.databinding.FragmentMainBinding
import com.space.challenge.view.BaseFragment

class MainFragment : BaseFragment(), SeekBar.OnSeekBarChangeListener {
  private var binding: FragmentMainBinding? = null
  private var durability: Int = 0
  private var speed: Int = 0
  private var capacity: Int = 0

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setListeners()
    setViewParameters()
  }

  private fun setViewParameters() {
    binding?.skbDurability?.max = FEATURE_MAX_POINT - 2
    binding?.skbSpeed?.max = FEATURE_MAX_POINT - 2
    binding?.skbCapacity?.max = FEATURE_MAX_POINT - 2
  }

  private fun setListeners() {
    binding?.btnContinue?.setOnClickListener {
      if (isPointsValid()) {
        navController.navigate(
          R.id.act_btnContinue_to_bnvNavigation
        )
      }
    }

    binding?.skbDurability?.setOnSeekBarChangeListener(this)
    binding?.skbSpeed?.setOnSeekBarChangeListener(this)
    binding?.skbCapacity?.setOnSeekBarChangeListener(this)
  }

  private fun isPointsValid(): Boolean {
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