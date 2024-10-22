package com.example.skillbloomapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.skillbloomapp.databinding.FragmentCommunityBinding
import org.jetbrains.annotations.Nullable


class CommunityFragment: AppCompatActivity() {
    private lateinit var binding: FragmentCommunityBinding

    @Nullable
    fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityBinding.inflate(inflater, container, false)
        return binding.root
    }
}