package com.example.skillbloomapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skillbloomapp.api.ApiManager
import com.example.skillbloomapp.api.ApiState
import com.example.skillbloomapp.model.Place
import kotlinx.coroutines.launch

class PlaceViewModel : ViewModel() {
    private val _places = MutableLiveData<ApiState<List<Place>>>()
    val places: LiveData<ApiState<List<Place>>> = _places

    init {
        fetchPlaces()
    }

    private fun fetchPlaces() {
        viewModelScope.launch {
            _places.value = ApiState.loading()
            try {
                val response = ApiManager.apiService.getPlaces()
                _places.value = ApiState.success(response)
            } catch (e: Exception) {
                _places.value = ApiState.error(e.message ?: "Failed to fetch data")
            }
        }
    }
}