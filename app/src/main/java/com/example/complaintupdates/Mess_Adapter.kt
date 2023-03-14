package com.example.complaintupdates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.complaintupdates.models.Complaint_Mess

class Mess_Adapter (private val userList: ArrayList<Complaint_Mess>) : RecyclerView.Adapter<Mess_Adapter.PostViewHolder>() {


    class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val messText: TextView = itemView.findViewById(R.id.postTitle)
        val userText: TextView = itemView.findViewById(R.id.userName)
        val createdAt: TextView = itemView.findViewById(R.id.createdAt)
        val userComplaint: TextView = itemView.findViewById(R.id.complain)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val complaintMess: Complaint_Mess = userList[position]
        holder.messText.text = complaintMess.mess
        holder.userText.text = complaintMess.createdBy
        holder.userComplaint.text = complaintMess.text
        holder.createdAt.text = Utils.getTimeAgo(complaintMess.createdAt)

    }

    override fun getItemCount(): Int {
        return userList.size
    }
}