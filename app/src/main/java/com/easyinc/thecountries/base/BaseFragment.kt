package com.easyinc.thecountries.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.easyinc.thecountries.mobile_ui.MainActivity
import com.easyinc.thecountries.presentation.MainViewModel


abstract class BaseFragment: Fragment() {

    lateinit var mainViewModel: MainViewModel
    
    abstract fun layoutId(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        return inflater.inflate(layoutId(), container, false)
    }

}