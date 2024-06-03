package com.quyduoi.lab7_md18309_ph41939.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class RetrofitService {
    private val retrofit: Retrofit = Retrofit.Builder()
        //.baseUrl("http://10.0.2.2:3000/")
        .baseUrl("https://mockapi.io/projects/6663e7c0932baf9032a94da8.mockapi.io/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val movieService: MovieService by lazy {
        retrofit.create(MovieService::class.java)
    }
}