package com.example.skillbloomapp.ui.element.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.skillbloomapp.R
import com.example.skillbloomapp.data.api.client.State
import com.example.skillbloomapp.databinding.FragmentSearchBinding
import com.example.skillbloomapp.ui.element.adapter.FreelancerAdapter
import com.example.skillbloomapp.ui.viewmodel.FreelancerViewModel

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FreelancerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.returnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Hide BottomNavigationView
        val bottomNav = requireActivity().findViewById<View>(R.id.bottomNavigationView)
        bottomNav.visibility = View.GONE

        // Set up your UI here
        val adapter = FreelancerAdapter()
        val gridLayoutManager = GridLayoutManager(context, 2)
        binding.freelancerRecyclerView.layoutManager = gridLayoutManager
        binding.freelancerRecyclerView.adapter = adapter

        viewModel.fetchFreelancers()

        viewModel.freelancersState.observe(viewLifecycleOwner) { state ->
            when (state.state) {
                State.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.freelancerRecyclerView.visibility = View.GONE
                    binding.errorTextView.visibility = View.GONE
                }
                State.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    binding.freelancerRecyclerView.visibility = View.VISIBLE
                    binding.errorTextView.visibility = View.GONE
                    state.data?.let { adapter.submitList(it) }
                }
                State.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    binding.freelancerRecyclerView.visibility = View.GONE
                    binding.errorTextView.visibility = View.VISIBLE
                }
            }
        }
    }

        override fun onDestroyView() {
            super.onDestroyView()

            // Show BottomNavigationView again
            val bottomNav = requireActivity().findViewById<View>(R.id.bottomNavigationView)
            bottomNav.visibility = View.VISIBLE

            _binding = null
        }
    }
