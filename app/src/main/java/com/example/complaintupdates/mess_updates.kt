package com.example.complaintupdates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.complaintupdates.daos.MessDao

class mess_updates : AppCompatActivity() {
    private lateinit var messDao :MessDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mess_updates)
        messDao = MessDao()
    }

    fun MessSubBtn(view: View) {
        val editText = findViewById<EditText>(R.id.messComplaint)
        val input = editText.text.toString().trim()

        val editText2 = findViewById<EditText>(R.id.nameMess)
        val messReg = editText2.text.toString().trim()

        messDao.mess = messReg

        if(input.isNotEmpty()){
            messDao.addMess(input)
            Toast.makeText(this, "Update Registered", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}