package com.easyinc.thecountries.presentation.mapper

import com.easyinc.thecountries.domain.model.CountryDetails
import com.easyinc.thecountries.presentation.model.CountryDetailsView
import javax.inject.Inject

class CountryDetailsViewMapper @Inject constructor(): Mapper<CountryDetailsView,CountryDetails> {
    override fun mapTo(type: CountryDetails): CountryDetailsView {
        return CountryDetailsView(
            type.currency,
            type.flag,
            type.language,
            type.name,
            type.timezone
        )
    }

    override fun mapFrom(type: CountryDetailsView): CountryDetails {
        return CountryDetails(
            type.currency,
            type.flag,
            type.language,
            type.name,
            type.timezone
        )
    }
}