package com.easyinc.thecountries.remote.service

import com.easyinc.thecountries.remote.model.CountriesListModel
import com.easyinc.thecountries.remote.model.CountryDetailsModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface CountriesApi {

    @GET("all?fields=name;currencies;flag;languages;timezones")
    fun fetchCountriesAsync(): Deferred<List<CountriesListModel>>

    @GET("name/{name}")
    fun fetchCountryAsync(@Path("name") countryName: String): Deferred<List<CountryDetailsModel>>

}