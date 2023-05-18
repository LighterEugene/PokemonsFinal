package com.example.pokemons

import com.example.pokemons.data.PokemonData

interface PokemonView {
    fun openInfoPokemon(pokemon: PokemonData)
}
