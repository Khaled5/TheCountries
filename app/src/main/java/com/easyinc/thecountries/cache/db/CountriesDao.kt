package com.easyinc.thecountries.cache.db

import androidx.room.*
import com.easyinc.thecountries.cache.model.CachedCountry

@Dao
interface CountriesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCountries(citiesList: List<CachedCountry>)

    @Query("DELETE FROM country")
    suspend fun deleteAll()

    @Query("SELECT * from country")
    fun getCountries(): List<CachedCountry>
}