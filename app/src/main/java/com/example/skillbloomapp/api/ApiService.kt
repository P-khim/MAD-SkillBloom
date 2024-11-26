package com.example.skillbloomapp.api


import com.example.skillbloomapp.model.Place
import retrofit2.http.GET
import com.example.skillbloomapp.model.Profile
import retrofit2.http.Path

interface ApiService {

    @GET("images")
    suspend fun getPlaces(): List<Place>

    @GET("users/{id}")
    suspend fun getProfileById(@Path("id") profileId: Int): Profile
}