package com.example.skillbloomapp.data.api.service

import com.example.skillbloomapp.data.model.Categories
import com.example.skillbloomapp.data.model.Place
import retrofit2.http.GET

interface ApiService {

    @GET("images")
    suspend fun getPlaces(): List<Place>
    @GET("images")
    suspend fun loadEvent(): List<Categories>
}
