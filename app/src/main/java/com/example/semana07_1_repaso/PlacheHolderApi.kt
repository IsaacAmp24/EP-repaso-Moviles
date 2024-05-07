package com.example.semana07_1_repaso

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PlacheHolderApi {

    // metodo para obtener post por id
    @GET("posts/{id}")
    fun getPostById(@Path("id") id:Int): Call<Post>
}