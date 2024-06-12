package com.makulky.socialcooking

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.makulky.socialcooking.databinding.FragmentCreditBinding

class creditFragment : Fragment() {

    private var _binding: FragmentCreditBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreditBinding.inflate(inflater,container,false)

        binding.contactarBoton.setOnClickListener{
            val direccionCorreo = "mfigalo996@g.educaand.es"
            val asunto = "Consulta de la app ${getString(R.string.app_name)}"

            val enviarEmail = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(direccionCorreo))
                putExtra(Intent.EXTRA_SUBJECT, asunto)
            }
            startActivity(enviarEmail)
        }

        binding.upButton.setOnClickListener{
            findNavController().navigate(R.id.action_creditFragment_to_menuFragment)
        }

        return binding.root
    }

}