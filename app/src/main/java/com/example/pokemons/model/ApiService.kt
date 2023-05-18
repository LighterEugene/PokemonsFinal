package com.example.pokemons.model

import com.example.pokemons.data.PokemonDto
import com.example.pokemons.data.PokemonInfoDto
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("pokemon")
    fun getData(): Observable<PokemonDto>

    @GET("pokemon/{id}")
    fun getInfo(@Path ("id") id: String): Observable<PokemonInfoDto>
}