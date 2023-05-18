package com.example.pokemons

import com.example.pokemons.data.PokemonData
import com.example.pokemons.data.PokemonInfo

interface StartView {

    fun update(items: MutableList<PokemonData>)
    fun openInfo(pokemonInfo: PokemonInfo?)
}