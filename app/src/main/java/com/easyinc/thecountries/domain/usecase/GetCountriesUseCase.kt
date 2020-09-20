package com.easyinc.thecountries.domain.usecase

import com.easyinc.thecountries.domain.model.Country
import com.easyinc.thecountries.domain.repository.ICountryRepository
import com.easyinc.thecountries.domain.usecase.base.UseCase
import com.easyinc.thecountries.domain.util.CloudErrorMapper
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(
    errorUtil: CloudErrorMapper,
    private val countryRepository: ICountryRepository
): UseCase<List<Country>, String>(errorUtil) {
    override suspend fun executeOnBackground(params: String?): List<Country> {
        return countryRepository.fetchCountriesList()
    }
}