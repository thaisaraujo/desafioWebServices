package com.example.desafiowebservices.service


import com.example.desafiowebservices.models.Res
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Service{

    @GET("characters/1009610/comics")
    suspend fun getHQ(
        @Query("offset")p1: Int,
        @Query("limit")p2: Int,
        @Query("ts")p3: String,
        @Query("apikey")p4: String,
        @Query("hash")p5: String,
    ): Res
}

//serviço da retrofit
val retrofit = Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com/v1/public/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

//instancia do service atraves do retrofit
val service: Service = retrofit.create(Service::class.java)