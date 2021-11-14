package com.example.socialnethomework.ui.screens.profile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.socialnethomework.R
import com.example.socialnethomework.data.be.model.NewsRequest

class ProfileAdapter : RecyclerView.Adapter<ProfileAdapter.ViewHolder>() {

    private val serviceList = mutableListOf<NewsRequest>()

    fun loadServices(list: List<NewsRequest>) {
        serviceList.clear()
        serviceList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false))
    }

    override fun getItemCount(): Int {
        return serviceList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = serviceList[position]

        holder.textTitle.text = currentItem.title
        holder.textBody.text = currentItem.body

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textTitle: TextView = itemView.findViewById(R.id.tv_title)
        val textBody: TextView = itemView.findViewById(R.id.tv_body)
    }

}