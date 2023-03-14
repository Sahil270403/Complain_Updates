package com.example.complaintupdates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.complaintupdates.models.Complaint_Hostel

class Hostel_Adapter (private val userList: ArrayList<Complaint_Hostel>)  : RecyclerView.Adapter<Hostel_Adapter.PostViewHolder>() {

    class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val hostelText: TextView = itemView.findViewById(R.id.postTitle)
        val userText: TextView = itemView.findViewById(R.id.userName)
        val createdAt: TextView = itemView.findViewById(R.id.createdAt)
        val userComplaint: TextView = itemView.findViewById(R.id.complain)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        val complaintHostel:Complaint_Hostel = userList[position]
        holder.hostelText.text = complaintHostel.hostel
        holder.userText.text = complaintHostel.createdBy
        holder.userComplaint.text = complaintHostel.text
        holder.createdAt.text = Utils.getTimeAgo(complaintHostel.createdAt)

    }

    override fun getItemCount(): Int {
        return userList.size
    }

}