package com.quispe.alonso.laboratoriocalificado03

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.quispe.alonso.laboratoriocalificado03.databinding.ActivityEjercicio01Binding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class Ejercicio01 : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio01Binding
    private val teacherAdapter = TeacherAdapter { teacher, action ->
        when (action) {
            "call" -> callTeacher(teacher.phone_number)
            "email" -> emailTeacher(teacher.email)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        fetchTeachers()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = teacherAdapter
    }

    private fun fetchTeachers() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://private-effe28-tecsup1.apiary-mock.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(TeacherApi::class.java)
        api.getTeachers().enqueue(object : Callback<TeacherResponse> {
            override fun onResponse(call: Call<TeacherResponse>, response: Response<TeacherResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        teacherAdapter.submitList(it.teachers)
                    }
                } else {
                    showError("Error al obtener los datos")
                }
            }

            override fun onFailure(call: Call<TeacherResponse>, t: Throwable) {
                showError("Error de red: ${t.message}")
            }
        })
    }

    private fun callTeacher(phone: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phone")
        }
        startActivity(intent)
    }

    private fun emailTeacher(email: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:$email")
        }
        startActivity(Intent.createChooser(intent, "Enviar correo"))
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
