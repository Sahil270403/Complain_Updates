package com.example.complaintupdates.daos

import com.example.complaintupdates.models.Complaint_Mess
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MessDao {
    val db = FirebaseFirestore.getInstance()
    val postCollection = db.collection("Updates_Mess")
    var user = "ADMIN"
    var mess = ""


    fun addMess(text: String) {

        GlobalScope.launch {

            val currentTime = System.currentTimeMillis()
            val Mess = Complaint_Mess(text, user, mess, currentTime)
            postCollection.document().set(Mess)
        }
    }
}