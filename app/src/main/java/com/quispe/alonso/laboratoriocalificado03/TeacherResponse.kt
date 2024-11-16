package com.quispe.alonso.laboratoriocalificado03

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

data class TeacherResponse(
    val teachers: List<Teacher>
)