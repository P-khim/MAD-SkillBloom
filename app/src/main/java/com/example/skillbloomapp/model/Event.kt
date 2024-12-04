package com.example.skillbloomapp.model

import com.google.gson.annotations.SerializedName

data class Event (
    val id: String,
    val title: String,
    val detail: String?,
    @SerializedName("url") val imageUrl: String
)