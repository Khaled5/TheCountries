package com.easyinc.thecountries.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.easyinc.thecountries.base.BaseViewModel
import com.easyinc.thecountries.domain.repository.ICountryRepository
import com.easyinc.thecountries.domain.usecase.GetCountriesUseCase
import com.easyinc.thecountries.domain.usecase.GetCountryUseCase
import com.easyinc.thecountries.domain.usecase.RefreshCountriesUseCase
import com.easyinc.thecountries.presentation.mapper.CountryDetailsViewMapper
import com.easyinc.thecountries.presentation.mapper.CountryViewMapper
import com.easyinc.thecountries.presentation.model.CountryDetailsView
import com.easyinc.thecountries.presentation.model.CountryView
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

class MainViewModel @ViewModelInject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val getCountryUseCase: GetCountryUseCase,
    private val countryViewMapper: CountryViewMapper,
    private val countryDetailsViewMapper: CountryDetailsViewMapper,
    private val refreshCountriesUseCase: RefreshCountriesUseCase
): BaseViewModel() {

    private val country  by lazy{ MutableLiveData<CountryDetailsView>() }
    private val countriesList by lazy { MutableLiveData<List<CountryView>>() }
    private val countryDetailsError by lazy { MutableLiveData<Boolean>() }

    fun observeCountry(): LiveData<CountryDetailsView> = country
    fun observeCountriesList(): LiveData<List<CountryView>> = countriesList
    fun observeRefreshedCountries(): LiveData<List<CountryView>> = countriesList
    fun observeCountryDetailsError(): LiveData<Boolean> = countryDetailsError

    fun getCountryByName(countryName: String) {
        getCountryUseCase.execute(countryName) {
            onComplete {
                countryDetailsError.postValue(true)
                country.postValue(
                    countryDetailsViewMapper.mapTo(it)
                )
            }
            onError {
                countryDetailsError.postValue(false)
                countryMessage.postValue(it.message)
            }
            onCancel {

            }
        }
    }

    fun getCountries() {
        getCountriesUseCase.execute {
            onComplete {countries ->
                countriesList.postValue(
                    countries.map {
                        countryViewMapper.mapTo(it)
                    }
                )
            }
            onError {
                countryMessage.postValue(it.message)
            }
            onCancel {

            }
        }
    }

    fun refreshCountries() {
        refreshCountriesUseCase.execute {
            onComplete {countries ->
                countriesList.postValue(
                    countries.map {
                        countryViewMapper.mapTo(it)
                    }
                )
            }
            onError {
                countryMessage.postValue(it.message)
            }
            onCancel {

            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        getCountryUseCase.unsubscribe()
        getCountriesUseCase.unsubscribe()
        refreshCountriesUseCase.unsubscribe()
    }

}