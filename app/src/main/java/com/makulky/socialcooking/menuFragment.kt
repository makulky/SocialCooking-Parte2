package com.makulky.socialcooking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.makulky.socialcooking.databinding.FragmentMenuBinding

class menuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater,container,false)

        binding.salirButton.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_loginFragment)
        }

        binding.creditosButton.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_creditFragment)
        }

        binding.imagePerfil.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_perfilFragment)
        }

        binding.iniciarButton.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_inicioFragment)
        }

        return binding.root
    }
}