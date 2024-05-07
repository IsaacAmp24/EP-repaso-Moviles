package com.example.semana07_1_repaso

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// esta clase se encarga de manejar la vista de cada item
class PostViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    // se enlazan los controles
    val id = itemView.findViewById<TextView>(R.id.txtId2)
    val userId = itemView.findViewById<TextView>(R.id.txtUserId)
    val title = itemView.findViewById<TextView>(R.id.txtTitle)
    val body = itemView.findViewById<TextView>(R.id.txtBody)

    // funcion que renderiza los datos
    fun render(post: Post){
        // se asignan los valores a los controles
        id.text = post.id.toString()
        userId.text = post.userId.toString()
        title.text = post.title
        body.text = post.body
    }
}