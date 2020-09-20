package com.easyinc.thecountries.remote.model

import com.google.gson.annotations.SerializedName

data class CountryDetailsModel (
    @SerializedName("currencies")
    val currencies: List<Currency>,
    @SerializedName("flag")
    val flag: String,
    @SerializedName("languages")
    val languages: List<Language>,
    @SerializedName("name")
    val name: String,
    @SerializedName("timezones")
    val timezones: List<String>
)