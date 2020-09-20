package com.easyinc.thecountries.remote.mapper

import com.easyinc.thecountries.data.model.CountryEntity
import com.easyinc.thecountries.remote.model.CountriesListModel
import javax.inject.Inject

class CountriesListModelMapper @Inject constructor(): ModelMapper<CountriesListModel, CountryEntity> {
    override fun mapFrom(map: CountriesListModel): CountryEntity {
        return CountryEntity(
            map.flag,
            map.name
        )
    }

}