package com.makulky.socialcooking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.makulky.socialcooking.adapter.recetasAdapter
import com.makulky.socialcooking.databinding.FragmentInicioBinding

class inicioFragment : Fragment() {

    private var _binding: FragmentInicioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInicioBinding.inflate(inflater, container, false)

        initRecyclerView()

        binding.upButton.setOnClickListener{
            findNavController().navigate(R.id.action_inicioFragment_to_menuFragment)
        }

        llamarMenu()

        return binding.root
    }

    private fun llamarMenu(){
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {

                    true
                }
                R.id.navigation_fav -> {
                    findNavController().navigate(R.id.action_inicioFragment_to_favsFragment)
                    true
                }
                R.id.navigation_perfil -> {
                    // Acción para el ítem Notifications
                    findNavController().navigate(R.id.action_inicioFragment_to_perfilFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun initRecyclerView() {
        val recyclerView = binding.listadoRecetas
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = recetasAdapter(recetasProvider.listaRecetas, findNavController())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
