package com.example.skillbloomapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skillbloomapp.data.api.client.ApiManager
import com.example.skillbloomapp.data.api.client.ApiState
import com.example.skillbloomapp.data.model.Login
import kotlinx.coroutines.launch


class LoginViewModel: ViewModel() {

    private val _logInData = MutableLiveData<ApiState<Login>>()
    val loginData: LiveData<ApiState<Login>> get() = _logInData

    fun login(email: String, password: String) {
        _logInData.postValue(ApiState.loading())

        viewModelScope.launch {
            try {
                val response = ApiManager.apiService.login(email, password)
                if (response.isSuccess()) {
                    _logInData.postValue(ApiState.success(response.data))
                } else {
                    _logInData.postValue(ApiState.error("Incorrect email or password. Please try again."))
                }
            }
            catch (ex: Exception) {
                _logInData.postValue(ApiState.error("Incorrect email or password. Please try again."))
            }
        }
    }

}