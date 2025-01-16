package com.example.skillbloomapp.ui.element.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.skillbloomapp.R
import com.example.skillbloomapp.data.model.Freelancer
import com.squareup.picasso.Picasso

class FreelancerAdapter : ListAdapter<Freelancer, FreelancerAdapter.FreelancerViewHolder>(
    FreelancerItemCallback()
) {

    class FreelancerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.ivProfilePicture)
        private val roleTextView: TextView = itemView.findViewById(R.id.tvRole)
        private val jobCountTextView: TextView = itemView.findViewById(R.id.tvJobCount)
        private val moneyPerHourTextView: TextView = itemView.findViewById(R.id.tvMoneyPerHour)

        fun bind(freelancer: Freelancer) {
            roleTextView.text = freelancer.role
            jobCountTextView.text = "Jobs: ${freelancer.jobCount}"
            moneyPerHourTextView.text = "$${freelancer.moneyPerHour}/hr"
            Picasso.get()
                .load(freelancer.imageUrl)
//                .placeholder(R.drawable.placeholder)
                .into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FreelancerViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.freelancer_item, parent, false)
        return FreelancerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FreelancerViewHolder, position: Int) {
        val freelancer = getItem(position)
        holder.bind(freelancer)
    }
}

class FreelancerItemCallback : DiffUtil.ItemCallback<Freelancer>() {
    override fun areItemsTheSame(oldItem: Freelancer, newItem: Freelancer): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Freelancer, newItem: Freelancer): Boolean {
        return oldItem == newItem
    }
}
