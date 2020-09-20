package com.easyinc.thecountries.data.repository

import com.easyinc.thecountries.data.model.CountryEntity

interface CountryCache {

    suspend fun addCountries(countriesList: List<CountryEntity>)

    suspend fun deleteAll()

    suspend fun getCountries(): List<CountryEntity>

}