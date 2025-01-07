package com.example.skillbloomapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skillbloomapp.data.api.client.ApiManager
import com.example.skillbloomapp.data.api.client.ApiState
import com.example.skillbloomapp.data.api.client.State
import com.example.skillbloomapp.data.model.Place
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PlaceViewModel : ViewModel() {

    private val _placesState = MutableLiveData<ApiState<List<Place>>>()
    val placesState: LiveData<ApiState<List<Place>>> get() = _placesState

    fun fetchPlaces() {
        val apiService = ApiManager.apiService

        // Set loading state
        _placesState.postValue(ApiState(State.LOADING, null))
        viewModelScope.launch {
            try {

                // Fetch places directly as a list
                val places = apiService.getPlaces()
                _placesState.postValue(ApiState(State.SUCCESS, places))
            } catch (ex: Exception) {
                // Handle exceptions
                Log.e("PlaceViewModel", "[Fetch Places] Error: $ex")
                _placesState.postValue(ApiState(State.ERROR, null))
            }
        }
    }
}
