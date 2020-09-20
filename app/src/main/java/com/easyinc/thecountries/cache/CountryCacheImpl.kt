package com.easyinc.thecountries.cache

import com.easyinc.thecountries.cache.db.CountriesDao
import com.easyinc.thecountries.cache.mapper.CachedCountryMapper
import com.easyinc.thecountries.data.model.CountryEntity
import com.easyinc.thecountries.data.repository.CountryCache
import javax.inject.Inject

class CountryCacheImpl @Inject constructor(
    private val countriesDao: CountriesDao,
    private val cachedCountryMapper: CachedCountryMapper
): CountryCache {
    override suspend fun addCountries(countriesList: List<CountryEntity>) {
        countriesDao.addCountries(countriesList.map {
            cachedCountryMapper.mapToCache(it)
        })
    }

    override suspend fun deleteAll() {
        countriesDao.deleteAll()
    }

    override suspend fun getCountries(): List<CountryEntity> {
        return countriesDao.getCountries().map {
            cachedCountryMapper.mapFromCache(it)
        }
    }

}