package com.easyinc.thecountries.data.store

import com.easyinc.thecountries.data.model.CountryDetailsEntity
import com.easyinc.thecountries.data.model.CountryEntity
import com.easyinc.thecountries.data.repository.CountryCache
import com.easyinc.thecountries.data.repository.CountryDataStore
import javax.inject.Inject

class CountryCacheDataStore @Inject constructor(
    private val countryCache: CountryCache
): CountryDataStore {
    override suspend fun addCountries(countriesList: List<CountryEntity>) {
        countryCache.addCountries(countriesList)
    }

    override suspend fun deleteAll() {
        countryCache.deleteAll()
    }

    override suspend fun getCountries(): List<CountryEntity> {
        return countryCache.getCountries()
    }

    override suspend fun getCountry(countryName: String): CountryDetailsEntity {
        throw UnsupportedOperationException("Fetching Country isn't supported here...")
    }
}