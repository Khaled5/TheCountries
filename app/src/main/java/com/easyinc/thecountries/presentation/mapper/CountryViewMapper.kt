package com.easyinc.thecountries.presentation.mapper

import com.easyinc.thecountries.domain.model.Country
import com.easyinc.thecountries.presentation.model.CountryView
import javax.inject.Inject

class CountryViewMapper @Inject constructor(): Mapper<CountryView, Country> {
    override fun mapTo(type: Country): CountryView {
        return CountryView(
            type.flag,
            type.name,
            type.id
        )
    }

    override fun mapFrom(type: CountryView): Country {
        return Country(
            type.flag,
            type.name,
            type.id
        )
    }
}