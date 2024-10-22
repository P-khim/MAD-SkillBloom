package com.example.skillbloomapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.skillbloomapp.databinding.ActivityLandingBinding

class LandingActivity: AppCompatActivity() {

    private lateinit var binding: ActivityLandingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun showFragment(fragment: Fragment) {
        // Fragment Manager
        val fragmentManager: FragmentManager = supportFragmentManager

        // Fragment transaction
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        // Replace fragment
        fragmentTransaction.replace(binding.lytFragment.id, fragment)

        // Commit Transaction
        fragmentTransaction.commit()
    }
}