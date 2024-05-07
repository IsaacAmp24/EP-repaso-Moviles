package com.example.semana07_1_repaso

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    //variables
    lateinit var service:PlacheHolderApi
    lateinit var pos:Post

    // para la bd
    private lateinit var appDB: AppDataBase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")// url base de la api a consumir
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        service = retrofit.create<PlacheHolderApi>(PlacheHolderApi::class.java)

        // llamamos a la base de datos
        appDB = AppDataBase.getDatabase(this)

        var txtId: EditText = findViewById(R.id.txtID)
        var btnBuscar: Button = findViewById(R.id.btnConsultar)
        var btnGrabar: Button = findViewById(R.id.btnGrabar)
        var btnListar: Button = findViewById(R.id.btnListar)

        btnBuscar.setOnClickListener {
            getPostId(txtId.text.toString().toInt())
        }

        btnGrabar.setOnClickListener(){

            val  regPost = TablePost(
                pos?.id,
                pos?.userId,
                pos?.body,
                pos?.title
            )

            GlobalScope.launch(Dispatchers.IO) {
                appDB.postDao().insert(regPost)
            }

            val txtRes:TextView = findViewById(R.id.txtResultado)
            txtRes.text="Registro grabado en la base de datos"
        }

        // boton que redirige a la siguiente pantalla con los datos listados
        btnListar.setOnClickListener{
            val intent = Intent(this, pantalla2::class.java)
            startActivity(intent)
        }



    }

    private fun getPostId(id:Int){

        service.getPostById(id).enqueue(object : Callback<Post> {
            override fun onResponse(p0: Call<Post>, p1: Response<Post>) {
                pos=p1?.body()!!

                val txtRes:TextView = findViewById(R.id.txtResultado)

                txtRes.text="ID" + pos?.id.toString() + "\n" +
                        "UserID" + pos?.userId.toString() + "\n" +
                        "Title" + pos?.title.toString() + "\n" +
                        "Body" + pos?.body.toString() + "\n"

            }

            override fun onFailure(p0: Call<Post>, p1: Throwable) {
                p1?.printStackTrace()
            }
        })
    }
}