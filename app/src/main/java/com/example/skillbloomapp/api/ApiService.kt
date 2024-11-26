package com.example.skillbloomapp.api

import com.example.skillbloomapp.model.Event
import com.example.skillbloomapp.model.Place
import retrofit2.http.GET

interface ApiService {

    @GET("images")
    suspend fun getPlaces(): List<Place>
    @GET("images")
    suspend fun loadEvent(): List<Event>
}
