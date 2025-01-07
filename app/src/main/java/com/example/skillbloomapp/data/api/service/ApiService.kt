package com.example.skillbloomapp.data.api.service

import com.example.skillbloomapp.data.model.Categories
import com.example.skillbloomapp.data.model.Place
import com.example.skillbloomapp.data.model.Profile
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("images")
    suspend fun getPlaces(): List<Place>
    @GET("images")
    suspend fun loadEvent(): List<Categories>

    @GET("users/{id}")
    suspend fun getProfileById(@Path("id") profileId: Int): Profile

}
