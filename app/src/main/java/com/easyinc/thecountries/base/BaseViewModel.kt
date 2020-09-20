package com.easyinc.thecountries.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {

    val countryMessage by lazy { MutableLiveData<String>() }

    fun observeCountryMessage(): LiveData<String> = countryMessage
}