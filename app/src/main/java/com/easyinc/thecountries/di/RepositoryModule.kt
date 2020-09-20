package com.easyinc.thecountries.di

import com.easyinc.thecountries.cache.CountryCacheImpl
import com.easyinc.thecountries.data.CountryRepository
import com.easyinc.thecountries.data.repository.CountryCache
import com.easyinc.thecountries.data.repository.CountryRemote
import com.easyinc.thecountries.domain.repository.ICountryRepository
import com.easyinc.thecountries.remote.CountryRemoteImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideCountryCache(countryCacheImpl: CountryCacheImpl): CountryCache

    @Binds
    abstract fun provideCountryRemote(countryRemoteImpl: CountryRemoteImpl): CountryRemote

    @Binds
    abstract fun provideCountryRepository(countryRepositoryImpl: CountryRepository): ICountryRepository

}