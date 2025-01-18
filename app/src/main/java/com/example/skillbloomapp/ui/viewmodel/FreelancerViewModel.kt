package com.example.skillbloomapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skillbloomapp.data.api.client.ApiManager
import com.example.skillbloomapp.data.api.client.ApiState
import com.example.skillbloomapp.data.api.client.State
import com.example.skillbloomapp.data.model.Freelancer
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FreelancerViewModel : ViewModel() {

    private val _freelancersState = MutableLiveData<ApiState<List<Freelancer>>>()

    val freelancersState: LiveData<ApiState<List<Freelancer>>> get() = _freelancersState

    fun fetchFreelancers() {
        val apiService =  ApiManager.apiService

        _freelancersState.postValue(ApiState(State.LOADING, null))
        viewModelScope.launch {
            try {
                delay(500)
                val freelancers = apiService.getFreelancer()
                _freelancersState.postValue(ApiState(State.SUCCESS, freelancers))
            } catch (ex: Exception) {
                Log.e("com.example.skillbloomapp.ui.viewmodel.FreelancerViewModel", "[Fetch Freelancers] Error: $ex")
                _freelancersState.postValue(ApiState(State.ERROR, null))
            }
        }
    }
}
