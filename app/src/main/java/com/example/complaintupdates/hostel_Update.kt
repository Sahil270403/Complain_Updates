package com.example.complaintupdates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.complaintupdates.daos.HostelDao

class hostel_Update : AppCompatActivity() {
    private lateinit var hostelDao: HostelDao
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hostel_update)
        hostelDao = HostelDao()

    }

    fun hostelSubBtn(view: View) {
        val editText = findViewById<EditText>(R.id.compRegHostel)
        val input = editText.text.toString().trim()

        val editText2 = findViewById<EditText>(R.id.hostelReg)
        val hostelReg = editText2.text.toString().trim()

        hostelDao.hostel = hostelReg

        if(input.isNotEmpty()){
            hostelDao.addHostel(input)
            Toast.makeText(this, "Update Registered", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}