package com.easyinc.thecountries.domain.repository

import com.easyinc.thecountries.domain.model.Country
import com.easyinc.thecountries.domain.model.CountryDetails

interface ICountryRepository {

    suspend fun fetchCountriesListAndStoreInDB(): List<Country>

    suspend fun fetchCountriesList(): List<Country>

    suspend fun fetchCountryDetails(countryName: String): CountryDetails

}