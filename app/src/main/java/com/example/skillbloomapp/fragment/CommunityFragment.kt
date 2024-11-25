package com.example.skillbloomapp.fragment

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.skillbloomapp.databinding.FragmentCommunityBinding

class CommunityFragment : Fragment() {
    private var _binding: FragmentCommunityBinding? = null
    private val binding get() = _binding!!

    companion object {
        // Factory method to create a new instance of this fragment
        fun newInstance(title: String): CommunityFragment {
            val fragment = CommunityFragment()
            val args = Bundle()
            args.putString("TITLE_KEY", title)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCommunityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Example 1: Retrieve arguments passed to the fragment
        val title = arguments?.getString("TITLE_KEY")
        binding.communityText.text = title ?: "Default Title"

        // Example 2: Add a click listener to a button
        binding.communityButton.setOnClickListener {
            binding.communityText.text = "Button clicked!"
        }

        // Example 3: Customize the UI dynamically
        binding.communityText.setTextColor(resources.getColor(R.color.holo_blue_dark))
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Example: Nullify binding to prevent memory leaks
        _binding = null
    }
}
