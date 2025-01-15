package com.example.skillbloomapp.data.api.client
import com.example.skillbloomapp.data.api.service.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiManager {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(com.example.skillbloomapp.BuildConfig.apiBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}
