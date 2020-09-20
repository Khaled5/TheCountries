package com.easyinc.thecountries.presentation.mapper

interface Mapper<V, D> {

    fun mapTo(type: D): V

    fun mapFrom(type: V): D
}