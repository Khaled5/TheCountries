package com.easyinc.thecountries.data.repository

import com.easyinc.thecountries.data.model.CountryDetailsEntity
import com.easyinc.thecountries.data.model.CountryEntity

interface CountryRemote {

    suspend fun getCountries(): List<CountryEntity>

    suspend fun getCountry(countryName: String): CountryDetailsEntity

}