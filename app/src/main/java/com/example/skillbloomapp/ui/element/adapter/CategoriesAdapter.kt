//package com.example.skillbloomapp.adapter
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//
//class CategoriesAdapter : RecyclerView.Adapter<CategoriesViewHolder>() {
//    private var dataSet: List<String>? = null
//    fun setDataSet(dataSet: List<String>?) {
//        this.dataSet = dataSet
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val binding: CategoriesViewHolder =
//            CategoriesViewHolder.inflate(inflater, parent, false)
//        return CategoriesViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
//        val imageUrl = dataSet!![position]
//        holder.bind(imageUrl)
//    }
//
//    override fun getItemCount(): Int {
//        return if (dataSet == null) {
//            0
//        } else {
//            dataSet!!.size
//        }
//    }
//}