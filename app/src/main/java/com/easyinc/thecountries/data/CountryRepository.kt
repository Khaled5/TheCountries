package com.easyinc.thecountries.data

import com.easyinc.thecountries.data.mapper.CountryDetailsEntityMapper
import com.easyinc.thecountries.data.mapper.CountryEntityMapper
import com.easyinc.thecountries.data.store.CountryCacheDataStore
import com.easyinc.thecountries.data.store.CountryRemoteDataStore
import com.easyinc.thecountries.domain.model.Country
import com.easyinc.thecountries.domain.model.CountryDetails
import com.easyinc.thecountries.domain.repository.ICountryRepository
import javax.inject.Inject

class CountryRepository @Inject constructor(
    private val countryCacheDataStore: CountryCacheDataStore,
    private val countryRemoteDataStore: CountryRemoteDataStore,
    private val countryEntityMapper: CountryEntityMapper,
    private val countryDetailsEntityMapper: CountryDetailsEntityMapper
): ICountryRepository {

    override suspend fun fetchCountriesList(): List<Country> {
        val localCities = fetchCountriesListLocally()

        return if (localCities.isEmpty())
                fetchCountriesListAndStoreInDB()
            else
                localCities
    }

    override suspend fun fetchCountriesListAndStoreInDB(): List<Country> {

        val countries = countryRemoteDataStore.getCountries()
        countryCacheDataStore.deleteAll()
        countryCacheDataStore.addCountries(countries)
        return countryCacheDataStore.getCountries().map {
            countryEntityMapper.mapFrom(it)
        }

    }

    private suspend fun fetchCountriesListLocally(): List<Country> {
        return countryCacheDataStore.getCountries().map {
                countryEntityMapper.mapFrom(it)
            }
    }

    override suspend fun fetchCountryDetails(countryName: String): CountryDetails {
        return countryDetailsEntityMapper.mapFrom(countryRemoteDataStore.getCountry(countryName))
    }

}