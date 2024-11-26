package com.example.skillbloomapp.fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.skillbloomapp.databinding.FragmentProfileBinding
import com.example.skillbloomapp.viewmodel.ProfileViewModel


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchProfile(5)

        viewModel.profileData.observe(viewLifecycleOwner) {profile ->
            binding.txtName.text = profile.name
            binding.txtEmail.text = profile.email
        }
    }
}