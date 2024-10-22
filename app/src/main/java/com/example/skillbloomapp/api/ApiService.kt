package com.example.skillbloomapp.api

import com.example.skillbloomapp.model.Place
import retrofit2.http.GET

interface ApiService {

    @GET("iteapp-api/places.json")
    suspend fun getPlaces(): List<Place>
}