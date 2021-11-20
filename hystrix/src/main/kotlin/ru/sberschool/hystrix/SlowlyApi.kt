package ru.sberschool.hystrix

import feign.RequestLine

interface SlowlyApi {
    @RequestLine("GET /pokemon/ditto")
    fun getPokemon(): Pokemon
}


