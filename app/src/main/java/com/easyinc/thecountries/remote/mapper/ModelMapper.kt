package com.easyinc.thecountries.remote.mapper

interface ModelMapper<in M, out E> {

    fun mapFrom(map: M) : E
}