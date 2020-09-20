package com.easyinc.thecountries.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country")
data class CachedCountry(
    val countryName: String,
    val countryFlag: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
)