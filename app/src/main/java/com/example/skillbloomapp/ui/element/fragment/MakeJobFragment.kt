package com.example.skillbloomapp.ui.element.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.skillbloomapp.R
import com.example.skillbloomapp.databinding.FragmentMakeJobBinding

class MakeJobFragment : Fragment() {
    private var _binding: FragmentMakeJobBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMakeJobBinding.inflate(inflater, container, false)

        binding.returnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNav = requireActivity().findViewById<View>(R.id.bottomNavigationView)
        bottomNav.visibility = View.GONE
    }
    override fun onDestroyView() {
        super.onDestroyView()

        val bottomNav = requireActivity().findViewById<View>(R.id.bottomNavigationView)
        bottomNav.visibility = View.VISIBLE

        _binding = null
    }
}