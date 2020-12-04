package com.example.desafiowebservices.services

import com.example.desafiowebservices.models.Msg
import com.example.desafiowebservices.models.Results
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {
    @GET("comics")
    suspend fun getComicsRepo(
        @Query("offset")p1: Int,
        @Query("limit")p2: Int,
        @Query("ts") p3: String,
        @Query("apikey")p4: String,
        @Query("hash")p5: String,
        @Query("characters")p6: String,
//        @Query("orderBy")p7: String,
    ) : Msg
}

val retrofit = Retrofit.Builder()
    .baseUrl("https://gateway.marvel.com/v1/public/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val service: Service = retrofit.create(Service::class.java)

