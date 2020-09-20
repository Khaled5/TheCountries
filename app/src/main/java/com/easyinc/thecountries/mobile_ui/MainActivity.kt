package com.easyinc.thecountries.mobile_ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.easyinc.thecountries.R
import com.easyinc.thecountries.base.extentions.snack
import com.easyinc.thecountries.presentation.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.observeCountryMessage().observe(this, Observer {
            showSnackbar(it)
            showProgressbar(false)
        })

    }

    fun showProgressbar(show: Boolean){
        frame_loading?.visibility = if (show) View.VISIBLE else View.GONE
    }

    fun showSnackbar(message: String, sView: View = nav_host_fragment){
        sView.snack(message)
    }


}