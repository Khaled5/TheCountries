package com.easyinc.thecountries.data.store

import com.easyinc.thecountries.data.model.CountryDetailsEntity
import com.easyinc.thecountries.data.model.CountryEntity
import com.easyinc.thecountries.data.repository.CountryDataStore
import com.easyinc.thecountries.data.repository.CountryRemote
import javax.inject.Inject

class CountryRemoteDataStore @Inject constructor(
    private val remoteCountry: CountryRemote
): CountryDataStore{
    override suspend fun addCountries(countriesList: List<CountryEntity>) {
        throw UnsupportedOperationException("Fetching Country isn't supported here...")
    }

    override suspend fun deleteAll() {
        throw UnsupportedOperationException("Fetching Country isn't supported here...")
    }

    override suspend fun getCountries(): List<CountryEntity> {
        return remoteCountry.getCountries()
    }

    override suspend fun getCountry(countryName: String): CountryDetailsEntity {
        return remoteCountry.getCountry(countryName)
    }

}