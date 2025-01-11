package com.example.skillbloomapp.data.api.client

data class ApiResponse<T>(
    val status: String,
    val message: String,
    val data: T?
) {

    fun isSuccess(): Boolean {
        return status == "success"
    }


}