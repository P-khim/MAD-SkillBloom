package com.example.skillbloomapp.ui.element.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.skillbloomapp.R
import com.example.skillbloomapp.ui.element.fragment.MakeJobFragment
import com.example.skillbloomapp.ui.element.fragment.PostPageFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PostBottomSheet : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnPost: Button = view.findViewById(R.id.btnPost)
        btnPost.setOnClickListener {
            navigateToPostPageFragment()
        }

        val btnMakeAJob: Button = view.findViewById(R.id.btnMakeAJob)
        btnMakeAJob.setOnClickListener {
            navigateToMakeJobFragment()
        }
    }

    private fun navigateToPostPageFragment() {
        dismiss()

        parentFragmentManager.beginTransaction()
            .replace(R.id.lytFragment, PostPageFragment())
            .addToBackStack(null)
            .commit()
    }
    private fun navigateToMakeJobFragment() {
        dismiss()

        parentFragmentManager.beginTransaction()
            .replace(R.id.lytFragment, MakeJobFragment())
            .addToBackStack(null)
            .commit()
    }
}
