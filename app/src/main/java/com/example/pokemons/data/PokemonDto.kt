package com.example.pokemons.data

data class PokemonDto(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)