package com.example.skillbloomapp.api

import com.example.skillbloomapp.model.Place
import retrofit2.http.GET

interface ApiService {

    @GET("images")
    suspend fun getPlaces(): List<Place>
}
