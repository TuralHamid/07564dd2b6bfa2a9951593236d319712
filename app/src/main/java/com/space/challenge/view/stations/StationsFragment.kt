package com.space.challenge.view.stations

import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.space.challenge.R
import com.space.challenge.databinding.FragmentStationsBinding
import com.space.challenge.domain.model.Station
import com.space.challenge.model.SpaceShip
import com.space.challenge.utils.filterSearchedStations
import com.space.challenge.utils.hideView
import com.space.challenge.utils.showView
import com.space.challenge.view.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.pow
import kotlin.math.sqrt

@AndroidEntryPoint
class StationsFragment : BaseFragment(), StationsAdapter.StationClickListener {
  private var binding: FragmentStationsBinding? = null
  private lateinit var stationsAdapter: StationsAdapter
  private lateinit var layoutManager: LinearLayoutManager
  private var currentStationList: List<Station>? = listOf()
  private var spaceShip: SpaceShip? = null
  private var ugsValue: Long? = null
  private var eusValue: Double? = null
  private var dsValue: Long? = null
  private var timer: CountDownTimer? = null
  private var damageValue: Int = 100
  private var currentXCoordinate: Double = 0.0
  private var currentYCoordinate: Double = 0.0

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    spaceShip = savedInstanceState?.getParcelable(STATE_SPACE_SHIP)
      ?: arguments?.getParcelable(ARG_SPACE_SHIP)
    currentStationList = arguments?.getParcelableArrayList(ARG_STATIONS)
    setFeatureValues()
    startTimerThread()
  }

  private fun setFeatureValues() {
    ugsValue = spaceShip?.capacity?.times(UGS_MULTIPLIER)
    eusValue = spaceShip?.speed?.times(EUS_MULTIPLIER)?.toDouble()
    dsValue = spaceShip?.durability?.times(DS_MULTIPLIER)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setListeners()
    setViewParameters()
    initAdapter()
  }

  private fun setListeners() {
    binding?.imvArrowBack?.setOnClickListener {
      val pos = layoutManager.findFirstVisibleItemPosition()
      if (pos > 0) {
        binding?.rcvStations?.scrollToPosition(pos - 1)
      } else {
        binding?.rcvStations?.scrollToPosition(0)
      }
    }

    binding?.imvArrowForward?.setOnClickListener {
      val pos = layoutManager.findFirstVisibleItemPosition()
      val itemCount = stationsAdapter.itemCount
      if (pos < itemCount - 1) {
        binding?.rcvStations?.scrollToPosition(pos + 1)
      } else {
        binding?.rcvStations?.scrollToPosition(itemCount - 1)
      }
    }

    binding?.edtSearch?.addTextChangedListener(object : TextWatcher {
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
        searchStations(s.toString())
      }
    })
  }

  private fun searchStations(s: String?) {
    if (!s.isNullOrEmpty()) {
      val filteredList = currentStationList?.filterSearchedStations(s)
      if (filteredList?.isNotEmpty() == true) {
        binding?.tvStationEmpty?.hideView()
      } else {
        binding?.tvStationEmpty?.showView()
      }
      stationsAdapter.setItems(filteredList?.toMutableList())
    } else {
      stationsAdapter.setItems(currentStationList?.toMutableList())
    }
  }

  private fun setViewParameters() {
    binding?.tvName?.text = spaceShip?.name
    binding?.tvUgsValue?.text = ugsValue.toString()
    binding?.tvEusValue?.text = eusValue.toString()
    binding?.tvDsValue?.text = dsValue.toString()
    binding?.tvDamage?.text = damageValue.toString()
  }

  private fun initAdapter() {
    stationsAdapter = StationsAdapter(context, this)
    binding?.let {
      it.rcvStations.setHasFixedSize(true)
      it.rcvStations.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
      it.rcvStations.adapter = stationsAdapter
    }
    layoutManager = binding?.rcvStations?.layoutManager as LinearLayoutManager
    stationsAdapter.setItems(currentStationList?.toMutableList())
  }

  private fun startTimerThread() {
    timer = object : CountDownTimer(dsValue ?: 0, 1000) {
      override fun onTick(millisUntilFinished: Long) {
        binding?.tvDamageTime?.text = String.format("%ss", millisUntilFinished.div(1000).toString())
      }

      override fun onFinish() {
        damageValue -= DAMAGE_SUBTRACT_VALUE
        binding?.tvDamage?.text = damageValue.toString()
        if (damageValue > 0) {
          startTimerThread()
        } else {
          timer?.cancel()
        }
      }
    }
    timer?.start()
  }

  private fun calculateTravel(station: Station?) {

  }

  private fun isDeliveryCompleted(): Boolean {
    return damageValue == 0 || ugsValue == 0L || eusValue?.compareTo(getStationsDistanceSum()) == -1
  }

  private fun getStationsDistanceSum(): Double {
    var distSum = 0.0
    currentStationList?.forEach {
      it.coordinateX?.let { x ->
        it.coordinateY?.let { y ->
          if (it.capacity == it.stock) {
            distSum += getDistance(x, y)
          }
        }
      }
    }
    return distSum
  }

  private fun getDistance(x: Double, y: Double): Double {
    return sqrt(((x.minus(currentXCoordinate)).pow(2).plus((y.minus(currentYCoordinate)).pow(2))))
  }

  override fun onTravelClicked(station: Station?) {
    calculateTravel(station)
    if (isDeliveryCompleted()) {
      binding?.tvCurrentStation?.text = getString(R.string.stations_tv_initial_station_text)
    }
  }

  override fun onFavoriteClicked(station: Station?) {
    if (station?.isFavorite == true) {
      station.let {
        stationsAdapter.getItem(station.pos)?.isFavorite = false
        stationsAdapter.notifyItemChanged(station.pos)
      }
    } else {
      station?.let {
        stationsAdapter.getItem(it.pos)?.isFavorite = true
        stationsAdapter.notifyItemChanged(station.pos)
      }
    }
  }

  override fun onSaveInstanceState(outState: Bundle) {
    outState.putParcelable(STATE_SPACE_SHIP, spaceShip)
    super.onSaveInstanceState(outState)
  }

  override fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): ViewBinding? {
    if (binding == null) {
      binding = FragmentStationsBinding.inflate(inflater, container, false)
    }
    return binding
  }

  override fun destroyViewBinding() {
    binding = null
  }

  override fun showBnv(): Boolean {
    return true
  }

  companion object {
    private const val UGS_MULTIPLIER: Long = 10000
    private const val EUS_MULTIPLIER: Long = 20
    private const val DS_MULTIPLIER: Long = 10000
    private const val DAMAGE_SUBTRACT_VALUE: Int = 10
    val ARG_SPACE_SHIP = "arg:spaceShip.${this::class.java.canonicalName}"
    private val STATE_SPACE_SHIP = "state:spaceShip.${this::class.java.canonicalName}"
    val ARG_STATIONS = "arg:stations.${this::class.java.canonicalName}"
  }
}