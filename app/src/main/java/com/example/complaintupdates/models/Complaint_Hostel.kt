package com.example.complaintupdates.models

data class Complaint_Hostel(
    val text: String = "",
    val createdBy: String = "ADMIN",
    val hostel:String = "",
    val createdAt:Long = 0L
)