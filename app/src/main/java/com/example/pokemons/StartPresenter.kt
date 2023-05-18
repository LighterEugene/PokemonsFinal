package com.example.pokemons

import com.example.pokemons.data.PokemonData
import com.example.pokemons.data.PokemonInfo
import com.example.pokemons.model.PokemonInteractor

class StartPresenter(private val view: StartView) : PokemonView {

    val interactor = PokemonInteractor()

    fun getPokemons() {
        // disposable нужно закрыть
        val disposable = interactor.getPokemons()?.map { result ->
            val listPokemon: MutableList<PokemonData> = mutableListOf()
            result.results.forEach {
                val id = it.url.replace("https://pokeapi.co/api/v2/pokemon/", "").replace("/", "")
                listPokemon.add(PokemonData(it.name, id))
            }
            listPokemon
        }?.subscribe({
            view.update(it)
        }, {
            //showDialogError(it)
        })
    }

    override fun openInfoPokemon(pokemon: PokemonData) {
        // disposable нужно закрыть
        val disposable = interactor.getInfo(pokemon.id)?.map {
            val info = PokemonInfo(it.height, it.name, it.sprites, it.types[0], it.weight)
            return@map info
        }?.subscribe({
            view.openInfo(it)
        }, {
            //showDialogError(it)
        })
    }
}