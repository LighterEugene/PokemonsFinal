package com.example.pokemons

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemons.adapter.PokemonAdapter
import com.example.pokemons.data.PokemonData
import com.example.pokemons.data.PokemonInfo
import com.example.pokemons.databinding.FragmentStartBinding


class StartFragment : Fragment(), StartView {

    var presenter: StartPresenter? = null
    var binding: FragmentStartBinding? = null
    var adapter: PokemonAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = StartPresenter(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        binding?.rv?.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapter = presenter?.let { PokemonAdapter(it) }
        binding?.rv?.adapter = adapter
        presenter?.getPokemons()
        return binding?.root
    }

    override fun update(items: MutableList<PokemonData>) {
        adapter?.updateItems(items)
    }

    override fun openInfo(pokemonInfo: PokemonInfo?) {
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        val secondFragment = InfoFragment.newInstance(pokemonInfo)

        transaction.replace(R.id.container, secondFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}