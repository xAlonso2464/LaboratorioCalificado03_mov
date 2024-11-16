package com.quispe.alonso.laboratoriocalificado03

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


data class Teacher(
    val name: String,
    val last_name: String,
    val phone_number: String,
    val email: String,
    val image_url: String
)