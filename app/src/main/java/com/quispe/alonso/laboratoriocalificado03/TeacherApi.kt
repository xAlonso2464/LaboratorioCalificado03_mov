package com.quispe.alonso.laboratoriocalificado03

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import retrofit2.Call
import retrofit2.http.GET


interface TeacherApi {
    @GET("list/teacher-b")
    fun getTeachers(): Call<TeacherResponse>
}