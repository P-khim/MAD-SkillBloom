package com.example.skillbloomapp.ui.element.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.skillbloomapp.R
import com.example.skillbloomapp.data.model.Profile


class ProfileAdapter(private var profile: Profile? = null) : RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {

    class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val fullname: TextView = itemView.findViewById(R.id.txtName)
        private val username: TextView = itemView.findViewById(R.id.txtEmail)

        fun bind(profile: Profile) {
            fullname.text = profile.name
            username.text = profile.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_profile, parent, false)
        return ProfileViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        profile?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int = if (profile == null) 0 else 1

    @SuppressLint("NotifyDataSetChanged")
    fun updateProfile(newProfile: Profile) {
        this.profile = newProfile
        notifyDataSetChanged()
    }
}