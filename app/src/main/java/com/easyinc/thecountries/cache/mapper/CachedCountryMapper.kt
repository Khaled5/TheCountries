package com.easyinc.thecountries.cache.mapper

import com.easyinc.thecountries.cache.model.CachedCountry
import com.easyinc.thecountries.data.model.CountryEntity
import javax.inject.Inject

class CachedCountryMapper @Inject constructor(): CacheMapper<CachedCountry, CountryEntity> {

    override fun mapFromCache(cache: CachedCountry): CountryEntity {
       return CountryEntity(
           cache.countryFlag,
           cache.countryName,
           cache.id
       )
    }

    override fun mapToCache(entity: CountryEntity): CachedCountry {
        return CachedCountry(
            entity.name,
            entity.flag
        )
    }
}