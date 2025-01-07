package com.example.skillbloomapp.data.model

import com.google.gson.annotations.SerializedName

data class Place (
    val id: String,
    val name: String,
    val detail: String?,
    @SerializedName("url") val imageUrl: String
)