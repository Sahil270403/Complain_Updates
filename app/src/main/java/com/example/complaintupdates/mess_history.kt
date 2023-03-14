package com.example.complaintupdates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.complaintupdates.models.Complaint_Mess
import com.google.firebase.firestore.*

class mess_history : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<Complaint_Mess>
    private lateinit var Mess_Adapter:Mess_Adapter
    private lateinit var db : FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mess_history)

        recyclerView = findViewById(R.id.RecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        userArrayList = arrayListOf()

        Mess_Adapter = Mess_Adapter(userArrayList)

        recyclerView.adapter = Mess_Adapter

        EventChangeListener()
    }
    private fun EventChangeListener() {

        db = FirebaseFirestore.getInstance()
        db.collection("Complaint_Mess").addSnapshotListener(object :
            EventListener<QuerySnapshot> {
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                if (error != null){

                    Log.e("Firestore Error", error.message.toString())
                    return
                }

                for (dc : DocumentChange in value?.documentChanges!!){

                    if(dc.type == DocumentChange.Type.ADDED){

                        userArrayList.add(dc.document.toObject(Complaint_Mess::class.java))
                        userArrayList.sortByDescending {
                            it.createdAt
                        }
                    }
                }

                Mess_Adapter.notifyDataSetChanged()

            }

        })

    }
}