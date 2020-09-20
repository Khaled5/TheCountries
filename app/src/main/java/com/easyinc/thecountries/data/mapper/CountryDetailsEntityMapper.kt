package com.easyinc.thecountries.data.mapper

import com.easyinc.thecountries.data.model.CountryDetailsEntity
import com.easyinc.thecountries.domain.model.CountryDetails
import javax.inject.Inject

class CountryDetailsEntityMapper @Inject constructor(): EntityMapper<CountryDetailsEntity, CountryDetails> {

    override fun mapFrom(entity: CountryDetailsEntity): CountryDetails {
        return CountryDetails(
            entity.currency,
            entity.flag,
            entity.language,
            entity.name,
            entity.timezone
        )
    }

    override fun mapTo(entity: CountryDetails): CountryDetailsEntity {
        return CountryDetailsEntity(
            entity.currency,
            entity.flag,
            entity.language,
            entity.name,
            entity.timezone
        )
    }
}