package com.example.semana07_1_repaso

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class pantalla2 : AppCompatActivity() {

    private lateinit var appDB: AppDataBase
    private lateinit var postList: List<Post>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla2)

        // llamamos a la base de datos
        appDB = AppDataBase.getDatabase(this)
        val recycler: RecyclerView = findViewById(R.id.recyclerPosts)

        // cargamos los datos de la base de datos
        loadPosts()


        GlobalScope.launch (Dispatchers.IO){
            postList = appDB.postDao().getAll()
        }

        recycler.layoutManager = LinearLayoutManager(applicationContext)
        recycler.adapter = Adapter(postList)
    }

    // funcion que carga los datos de la base de datos
    private fun loadPosts(){
        postList = mutableListOf()
    }
}