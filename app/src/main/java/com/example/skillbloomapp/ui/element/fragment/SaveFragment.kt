package com.example.skillbloomapp.ui.element.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.skillbloomapp.R
import com.example.skillbloomapp.databinding.FragmentSaveBinding

class SaveFragment : Fragment() {
    private var _binding: FragmentSaveBinding? = null
    private lateinit var findAJob: TextView
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSaveBinding.inflate(inflater, container, false)
        val view = binding.root

        findAJob = view.findViewById(R.id.findAJob)

        findAJob.setOnClickListener {
            navigateToSearchFragment()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    private fun navigateToSearchFragment() {
        val searchFragment = SearchFragment()
        val bundle = Bundle()

        bundle.putString("key", "value")
        searchFragment.arguments = bundle

        parentFragmentManager.beginTransaction()
            .replace(R.id.lytFragment, searchFragment)
            .commit()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
