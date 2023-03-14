package com.example.complaintupdates

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.complaintupdates.daos.HostelDao
import com.example.complaintupdates.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.button1.setOnClickListener {
            startActivity(Intent(this,hostel_history::class.java))
        }
        binding.button.setOnClickListener {
            startActivity(Intent(this, hostel_Update::class.java))
        }

        binding.button3.setOnClickListener {
            startActivity(Intent(this,mess_history::class.java))
        }
        binding.button4.setOnClickListener {
            startActivity(Intent(this, mess_updates::class.java))
        }
    }
}