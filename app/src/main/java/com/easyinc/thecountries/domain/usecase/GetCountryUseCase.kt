package com.easyinc.thecountries.domain.usecase

import com.easyinc.thecountries.domain.model.CountryDetails
import com.easyinc.thecountries.domain.repository.ICountryRepository
import com.easyinc.thecountries.domain.usecase.base.UseCase
import com.easyinc.thecountries.domain.util.CloudErrorMapper
import javax.inject.Inject

class GetCountryUseCase @Inject constructor(
    errorUtil: CloudErrorMapper,
    private val countryRepository: ICountryRepository
): UseCase<CountryDetails, String>(errorUtil) {
    override suspend fun executeOnBackground(params: String?): CountryDetails {
        return countryRepository.fetchCountryDetails(params!!)
    }
}