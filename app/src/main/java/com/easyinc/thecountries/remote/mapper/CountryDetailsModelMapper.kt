package com.easyinc.thecountries.remote.mapper

import com.easyinc.thecountries.data.model.CountryDetailsEntity
import com.easyinc.thecountries.remote.model.CountryDetailsModel
import javax.inject.Inject


class CountryDetailsModelMapper @Inject constructor(): ModelMapper<CountryDetailsModel, CountryDetailsEntity> {

    override fun mapFrom(map: CountryDetailsModel): CountryDetailsEntity {
        return CountryDetailsEntity(
            map.currencies[0].name,
            map.flag,
            map.languages[0].name,
            map.name,
            map.timezones[0]
        )
    }

}