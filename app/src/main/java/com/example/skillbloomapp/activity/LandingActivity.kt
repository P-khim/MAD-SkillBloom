package com.example.skillbloomapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.skillbloomapp.databinding.ActivityLandingBinding

class LandingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLandingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the onClickListener for the onToNext view
        binding.onToNext.setOnClickListener {
            navigateToSplashActivity()
        }
    }

    private fun navigateToSplashActivity() {
        // Start SplashActivity
        val intent = Intent(this, SplashActivity::class.java)
        startActivity(intent)
    }
}
