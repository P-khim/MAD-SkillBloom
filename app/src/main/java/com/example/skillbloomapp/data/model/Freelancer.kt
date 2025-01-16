package com.example.skillbloomapp.data.model

import com.google.gson.annotations.SerializedName

data class Freelancer(
    val id: String,
    val role: String,
    val jobCount: Int,
    val moneyPerHour: Int,
    @SerializedName("profilePicture") val imageUrl: String
)
