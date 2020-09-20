package com.easyinc.thecountries.remote

import com.easyinc.thecountries.data.model.CountryDetailsEntity
import com.easyinc.thecountries.data.model.CountryEntity
import com.easyinc.thecountries.data.repository.CountryRemote
import com.easyinc.thecountries.remote.mapper.CountriesListModelMapper
import com.easyinc.thecountries.remote.mapper.CountryDetailsModelMapper
import com.easyinc.thecountries.remote.service.CountriesApi
import javax.inject.Inject

class CountryRemoteImpl @Inject constructor(
    private val countriesApi: CountriesApi,
    private val countriesModelMapper: CountriesListModelMapper,
    private val countryModelMapper: CountryDetailsModelMapper
): CountryRemote {

    override suspend fun getCountries(): List<CountryEntity> {
        return countriesApi.fetchCountriesAsync().await().map {
            countriesModelMapper.mapFrom(it)
        }
    }

    override suspend fun getCountry(countryName: String): CountryDetailsEntity {
        return countryModelMapper.mapFrom(countriesApi.fetchCountryAsync(countryName).await()[0])
    }

}