package com.example.skillbloomapp.ui.element.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.skillbloomapp.R
import com.example.skillbloomapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var viewAll: TextView
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        viewAll = view.findViewById(R.id.view_all)

        viewAll.setOnClickListener {
            navigateToSearchFragment()
        }
        return view
    }

    private fun navigateToSearchFragment() {
        val searchFragment = SearchFragment() // Create an instance of the target fragment

        // Optional: Pass data to SearchFragment
        val bundle = Bundle()
        bundle.putString("key", "value") // Replace "key" and "value" with actual data
        searchFragment.arguments = bundle

        // Replace the current fragment with SearchFragment
        parentFragmentManager.beginTransaction()
            .replace(R.id.lytFragment, searchFragment) // Replace with the correct container ID
            .addToBackStack(null) // Allows navigating back to HomeFragment
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
