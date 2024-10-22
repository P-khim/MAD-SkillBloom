package com.example.skillbloomapp.activity
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.skillbloomapp.R
import com.example.skillbloomapp.adapter.PlaceAdapter
import com.example.skillbloomapp.api.State
import com.example.skillbloomapp.viewmodel.PlaceViewModel


class MainActivity : AppCompatActivity() {

    private val viewModel: PlaceViewModel by viewModels()

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.placesRecyclerView)
        val progressBar: ProgressBar = findViewById(R.id.progressBar)
        val errorTextView: TextView = findViewById(R.id.errorTextView)

        val adapter = PlaceAdapter()
        recyclerView.adapter = adapter

        viewModel.places.observe(this as LifecycleOwner) { state ->
            when (state.state) {
                State.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                    errorTextView.visibility = View.GONE
                }
                State.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    recyclerView.visibility = View.VISIBLE
                    errorTextView.visibility = View.GONE
                    state.data?.let { adapter.submitList(it) }
                }
                State.ERROR -> {
                    progressBar.visibility = View.GONE
                    recyclerView.visibility = View.GONE
                    errorTextView.visibility = View.VISIBLE
                    Log.e("MainActivity", "Error: ${state.message}")
                }
            }
        }
    }
}