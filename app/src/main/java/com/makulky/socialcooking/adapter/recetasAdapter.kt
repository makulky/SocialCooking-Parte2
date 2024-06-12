package com.makulky.socialcooking.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.makulky.socialcooking.R
import com.makulky.socialcooking.datosRecetas

class recetasAdapter(private val listaRecetas:List<datosRecetas>, private val navController: NavController) : RecyclerView.Adapter<recetasViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recetasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return recetasViewHolder(layoutInflater.inflate(R.layout.recetas_layout, parent, false), navController)
    }

    override fun getItemCount(): Int {
        return listaRecetas.size
    }

    override fun onBindViewHolder(holder: recetasViewHolder, position: Int) {
        val item = listaRecetas[position]
        holder.render(item)
    }
}