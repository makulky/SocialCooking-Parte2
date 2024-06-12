package com.makulky.socialcooking.adapter

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.makulky.socialcooking.R
import com.makulky.socialcooking.databinding.RecetasLayoutBinding
import com.makulky.socialcooking.datosRecetas

class recetasViewHolder(view: View, private val navController: NavController) : RecyclerView.ViewHolder(view) {

    val binding = RecetasLayoutBinding.bind(view)

    fun render(datosRecetasModel: datosRecetas) {
        binding.nombreRecetaTextView.text = datosRecetasModel.nombre
        binding.autorRecetaTextView.text = datosRecetasModel.autor
        binding.calificacionRecetaTextView.text = datosRecetasModel.dificultad
        Glide.with(binding.imagenReceta.context).load(datosRecetasModel.urlFoto).into(binding.imagenReceta)

        itemView.setOnClickListener {
            val bundle = Bundle().apply {
                putString("nombre", datosRecetasModel.nombre)
                putString("autor", datosRecetasModel.autor)
                putString("dificultad", datosRecetasModel.dificultad)
                putString("urlFoto", datosRecetasModel.urlFoto)
            }
            navController.navigate(R.id.action_inicioFragment_to_contenidoCeldaFragment, bundle)
        }

        binding.favButton.setOnClickListener {
            Toast.makeText(itemView.context, "Se ha añadido a favoritos!", Toast.LENGTH_SHORT).show()
        }
    }
}
