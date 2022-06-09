package com.space.challenge.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(createViewBinding(layoutInflater)?.root)
  }

  override fun onDestroy() {
    viewModelStore.clear()
    destroyViewBinding()
    super.onDestroy()
  }

  abstract fun createViewBinding(inflater: LayoutInflater): ViewBinding?

  abstract fun destroyViewBinding()

}