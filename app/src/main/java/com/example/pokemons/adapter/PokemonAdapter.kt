package com.example.pokemons.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemons.PokemonView
import com.example.pokemons.adapter.viewholder.PokemonViewHolder
import com.example.pokemons.data.PokemonData
import com.example.pokemons.databinding.ItemPokemonBinding

class PokemonAdapter(val listener: PokemonView) : RecyclerView.Adapter<PokemonViewHolder>(){

    var items: List<PokemonData> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PokemonViewHolder(ItemPokemonBinding.inflate(inflater, parent, false), listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    fun updateItems(items: MutableList<PokemonData>){
        this.items = items
        notifyDataSetChanged()
    }
}