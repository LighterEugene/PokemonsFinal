package com.example.pokemons

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.pokemons.data.PokemonInfo
import com.example.pokemons.databinding.FragmentInfoBinding


class InfoFragment : Fragment() {

    var binding: FragmentInfoBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(inflater, container, false)

        val pokemonInfo: PokemonInfo? = requireArguments().getParcelable(POKEMON_INFO)

        Glide.with(this)
            .load(pokemonInfo?.sprites?.front_default)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding?.image!!)

        binding?.namePokemon?.text = pokemonInfo?.name
        binding?.type?.text = pokemonInfo?.types?.type?.name
        binding?.height?.text = "${pokemonInfo?.height} cm"
        binding?.weight?.text = "${pokemonInfo?.weight} kg"
        binding?.btn?.setOnClickListener {
            activity?.onBackPressed()
        }
        return binding?.root
    }

    companion object {
        const val POKEMON_INFO = "pokemon_info"

        @JvmStatic
        fun newInstance(pokemonInfo: PokemonInfo?) =
            InfoFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(POKEMON_INFO, pokemonInfo)
                }
            }
    }
}