package com.example.skillbloomapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.skillbloomapp.databinding.FragmentHomeBinding
import org.jetbrains.annotations.Nullable

class HomeFragment: AppCompatActivity() {
    private lateinit var binding: FragmentHomeBinding

    @Nullable
    fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
}