package com.example.skillbloomapp.ui.element.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.skillbloomapp.ui.element.adapter.PlaceAdapter
import com.example.skillbloomapp.data.api.client.State
import com.example.skillbloomapp.databinding.FragmentPostBinding
import com.example.skillbloomapp.ui.viewmodel.PlaceViewModel

class PostFragment : Fragment() {
    private var _binding: FragmentPostBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PlaceViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPostBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PlaceAdapter()
        binding.placesRecyclerView.adapter = adapter

        viewModel.fetchPlaces()

        viewModel.placesState.observe(viewLifecycleOwner) { state ->
            when (state.state) {
                State.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.placesRecyclerView.visibility = View.GONE
                    binding.errorTextView.visibility = View.GONE
                }

                State.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    binding.placesRecyclerView.visibility = View.VISIBLE
                    binding.errorTextView.visibility = View.GONE
                    state.data?.let { adapter.submitList(it) }
                }

                State.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    binding.placesRecyclerView.visibility = View.GONE
                    binding.errorTextView.visibility = View.VISIBLE
                    Log.e("HomeFragment", "Error: ${state.message}")
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
