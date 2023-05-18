package com.example.pokemons.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.pokemons.PokemonView
import com.example.pokemons.data.PokemonData
import com.example.pokemons.databinding.ItemPokemonBinding

class PokemonViewHolder(val binding: ItemPokemonBinding, val listener: PokemonView): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PokemonData){
        binding.namePokemon.text = item.name
        binding.containerPokemon.setOnClickListener {
            listener.openInfoPokemon(item)
        }
    }
}