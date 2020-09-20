package com.easyinc.thecountries.remote.model


import com.google.gson.annotations.SerializedName

data class CountriesListModel(
    @SerializedName("flag")
    val flag: String,
    @SerializedName("name")
    val name: String
)