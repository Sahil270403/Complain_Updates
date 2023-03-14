package com.example.complaintupdates.daos

import com.example.complaintupdates.models.Complaint_Hostel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HostelDao {
    val db = FirebaseFirestore.getInstance()
    val postCollection = db.collection("Updates_Hostel")
    var user = "ADMIN"
    var hostel = ""


    fun addHostel(text: String) {

        GlobalScope.launch {

            val currentTime = System.currentTimeMillis()
            val hostel = Complaint_Hostel(text, user,hostel , currentTime)
            postCollection.document().set(hostel)
        }
    }
}