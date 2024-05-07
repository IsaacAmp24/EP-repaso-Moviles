package com.example.semana07_1_repaso

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter (val listaPost: List<Post>) : RecyclerView.Adapter<PostViewHolder>(){

    // crea la vista de los datos a mostrar en el recycler
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PostViewHolder(layoutInflater.inflate(R.layout.card, parent, false))
    }

    // obtiene la cantidad de elementos a mostrar
    override fun getItemCount(): Int = listaPost.size

    // renderiza los datos
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = listaPost[position]
        holder.render(item)
    }

}