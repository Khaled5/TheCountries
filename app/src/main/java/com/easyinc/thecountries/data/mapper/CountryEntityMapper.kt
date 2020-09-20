package com.easyinc.thecountries.data.mapper

import com.easyinc.thecountries.data.model.CountryEntity
import com.easyinc.thecountries.domain.model.Country
import javax.inject.Inject

class CountryEntityMapper @Inject constructor(): EntityMapper<CountryEntity, Country> {

    override fun mapFrom(entity: CountryEntity): Country {
        return Country(
            entity.flag,
            entity.name,
            entity.id!!
        )
    }

    override fun mapTo(entity: Country): CountryEntity {
        return CountryEntity(
            entity.flag,
            entity.name,
            entity.id
            )
    }
}