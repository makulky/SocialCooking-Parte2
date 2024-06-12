package com.makulky.socialcooking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.makulky.socialcooking.databinding.FragmentFavsBinding

class favsFragment : Fragment() {

    private var _binding: FragmentFavsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavsBinding.inflate(inflater,container,false)

        binding.upButton.setOnClickListener{
            findNavController().navigate(R.id.action_favsFragment_to_inicioFragment)
        }

        llamarMenu()

        return binding.root
    }

    private fun llamarMenu() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    findNavController().navigate(R.id.action_favsFragment_to_inicioFragment)
                    true
                }

                R.id.navigation_fav -> {

                    true
                }

                R.id.navigation_perfil -> {
                    // Acción para el ítem Notifications
                    findNavController().navigate(R.id.action_favsFragment_to_perfilFragment)
                    true
                }

                else -> false
            }
        }
    }
}