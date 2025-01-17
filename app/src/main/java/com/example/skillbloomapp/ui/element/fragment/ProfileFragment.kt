package com.example.skillbloomapp.ui.element.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.skillbloomapp.databinding.FragmentProfileBinding
import com.example.skillbloomapp.global.AppPref
import com.example.skillbloomapp.ui.element.activity.LoginActivity
import com.example.skillbloomapp.ui.viewmodel.ProfileViewModel

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProfileViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)



        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.fetchProfile(1)

        updateUIBasedOnLoginStatus()

        viewModel.profileData.observe(viewLifecycleOwner){profile ->
            binding.txtName.text = profile.name
            binding.txtEmail.text = profile.email

        }

        binding.logginButton.setOnClickListener{
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)

        }

        binding.setting.setOnClickListener(){
            logout()
        }

    }

    private fun updateUIBasedOnLoginStatus(){
        val isLoggedIn = AppPref.get().isLoggedIn(requireContext())
        if(isLoggedIn) {
            binding.profilePage.isVisible = true
            binding.logginButton.isVisible = false
            viewModel.fetchProfile(1)
        } else{
            binding.profilePage.isVisible = false
            binding.logginButton.isVisible = true
        }
    }

    private fun logout(){
        AppPref.get().setLoggedIn(requireContext(), false)

        val intent = Intent(requireContext(), LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        activity?.finish()
    }

    override fun onResume() {
        super.onResume()
        updateUIBasedOnLoginStatus()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}
