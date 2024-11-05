package com.example.skillbloomapp.fragment

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.skillbloomapp.databinding.FragmentPostBinding
import org.jetbrains.annotations.Nullable

class PostFragment: AppCompatActivity() {
    private lateinit var binding: FragmentPostBinding

    @Nullable
    fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostBinding.inflate(inflater, container, false)
        return binding.root
    }
}