package com.makulky.socialcooking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.makulky.socialcooking.databinding.FragmentPerfilBinding

class perfilFragment : Fragment() {

    private var _binding: FragmentPerfilBinding? = null
    private val binding get() = _binding!!
    private val svm: sharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPerfilBinding.inflate(inflater, container, false)

        binding.nickTextView.text = "Bienvenido " + svm.usuario + "!"

        binding.upButton.setOnClickListener{
            findNavController().navigate(R.id.action_perfilFragment_to_menuFragment)
        }

        llamarMenu()

        return binding.root
    }

    private fun llamarMenu() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    findNavController().navigate(R.id.action_perfilFragment_to_inicioFragment)
                    true
                }

                R.id.navigation_fav -> {
                    findNavController().navigate(R.id.action_perfilFragment_to_favsFragment)
                    true
                }

                R.id.navigation_perfil -> {
                    // Acción para el ítem Notifications

                    true
                }

                else -> false
            }
        }
    }
}