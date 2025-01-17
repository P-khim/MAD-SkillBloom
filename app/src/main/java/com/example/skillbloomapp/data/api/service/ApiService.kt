package com.example.skillbloomapp.data.api.service

import com.example.skillbloomapp.data.api.client.ApiResponse
import com.example.skillbloomapp.data.model.Categories
import com.example.skillbloomapp.data.model.Freelancer
import com.example.skillbloomapp.data.model.Login
import com.example.skillbloomapp.data.model.Place
import com.example.skillbloomapp.data.model.Profile
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @GET("images")
    suspend fun getPlaces(): List<Place>

    @GET("users-profile")
    suspend fun getFreelancer(): List<Freelancer>

    @GET("users/{id}")
    suspend fun getProfileById(@Path("id") profileId: Int): Profile

    @FormUrlEncoded
    @POST("login")
    suspend fun login(@Field("username") username: String, @Field("password") password: String) : ApiResponse<Login>

}
