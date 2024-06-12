package com.makulky.socialcooking

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.makulky.socialcooking.databinding.FragmentLoginBinding

class loginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val svm: sharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.aceptarButton.setOnClickListener{

            var usuario = binding.nickText.text.toString()

            val toastError = getString(R.string.errorUsuario)
            val toast = getString(R.string.bienvenidoUsuario)

            if(usuario.isNotEmpty()){
                svm.usuario = usuario
                findNavController().navigate(R.id.action_loginFragment_to_menuFragment)
                Toast.makeText(requireContext(),toast + " " + usuario + "!", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(requireContext(),toastError, Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

}