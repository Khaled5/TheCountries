package com.easyinc.thecountries.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.easyinc.thecountries.cache.model.CachedCountry

@Database(
    entities = [CachedCountry::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun countriesDao(): CountriesDao

}