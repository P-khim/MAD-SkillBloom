package com.example.skillbloomapp.ui.element.activity

import android.content.Intent
import android.os.Bundle

import androidx.activity.viewModels

import com.example.skillbloomapp.data.api.client.ApiState
import com.example.skillbloomapp.data.api.client.State
import com.example.skillbloomapp.data.model.Login
import com.example.skillbloomapp.databinding.ActivityLoginBinding
import com.example.skillbloomapp.global.AppPref
import com.example.skillbloomapp.ui.viewmodel.LoginViewModel

class LoginActivity : BaseActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val  viewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpUi()
        setUpListener()
        setUpObserver()

        checkLoginStatus()
    }



    private fun setUpUi(){
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setUpListener(){
        binding.buttonLogin.setOnClickListener{onLoginButtonClick()}
        binding.buttonFillLater.setOnClickListener{onFillLaterButtonClick()}

    }

    private fun onLoginButtonClick() {
        val username = binding.editTextEmail.text.toString().trim()
        val password = binding.editTextPassword.text.toString().trim()
        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Invalid Input", "Please enter username and password")

            return
        }
        viewModel.login(username,password)

    }

    private fun onFillLaterButtonClick(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun setUpObserver(){
        viewModel.loginData.observe(this){
        handleState(it)
        }
    }

    private fun handleState(state: ApiState<Login>){
        when(state.state){
            State.LOADING -> showLoading()
            State.SUCCESS -> {
                AppPref.get().setLoggedIn(this, true)
                setResult(RESULT_OK)
                finish()
            }
            State.ERROR ->{
                hideLoading()
                showAlert("Error", state.message ?: "Unexpected Error")
            }
        }
    }

    private fun updateUiForLoggedInUser(){
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }

    private fun checkLoginStatus(){
        if(AppPref.get().isLoggedIn(this)){
            updateUiForLoggedInUser()
        }
    }
}