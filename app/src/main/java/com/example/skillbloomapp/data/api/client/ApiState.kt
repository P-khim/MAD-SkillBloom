package com.example.skillbloomapp.data.api.client

enum class State {
    LOADING,
    SUCCESS,
    ERROR,
}

data class ApiState<out T>(val state: State, val data: T? = null, val message: String? = null) {

    companion object {
        fun <T> loading() = ApiState<T>(State.LOADING)
        fun <T> success(data: T?) = ApiState(State.SUCCESS, data)
        fun <T> error(message: String) = ApiState<T>(State.ERROR, message = message)
    }
}