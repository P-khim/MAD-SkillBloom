package com.example.skillbloomapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.skillbloomapp.databinding.FragmentProfileBinding
import org.jetbrains.annotations.Nullable

class ProfileFragment: AppCompatActivity() {
    private lateinit var binding: FragmentProfileBinding

    @Nullable
    fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }
}