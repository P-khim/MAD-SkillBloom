package com.example.skillbloomapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skillbloomapp.data.api.client.ApiManager
import com.example.skillbloomapp.data.model.Profile
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel(){

    private val _profileData = MutableLiveData<Profile>()
    val profileData: LiveData<Profile> get() = _profileData

    fun fetchProfile(id: Int){
        viewModelScope.launch {
            try {
                val profiles = ApiManager.apiService.getProfileById(id)
                _profileData.value = profiles
            } catch (ex: Exception) {
                Log.e("ProfileViewModel", "[Fetch Profiles] Error : $ex")
            }
        }
    }
}