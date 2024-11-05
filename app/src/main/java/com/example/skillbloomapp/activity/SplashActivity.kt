package com.example.skillbloomapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.skillbloomapp.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate and set the content view to activity_splash.xml
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the onClickListener for the onToNext view
        binding.onToNext.setOnClickListener {
            navigateToHomeActivity()
        }
    }

    private fun navigateToHomeActivity() {
        // Start HomeActivity
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
