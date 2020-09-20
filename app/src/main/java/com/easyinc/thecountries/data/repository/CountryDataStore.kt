package com.easyinc.thecountries.data.repository

import com.easyinc.thecountries.data.model.CountryDetailsEntity
import com.easyinc.thecountries.data.model.CountryEntity

interface CountryDataStore {

    suspend fun addCountries(countriesList: List<CountryEntity>)

    suspend fun deleteAll()

    suspend fun getCountries(): List<CountryEntity>

    suspend fun getCountry(countryName: String): CountryDetailsEntity

}