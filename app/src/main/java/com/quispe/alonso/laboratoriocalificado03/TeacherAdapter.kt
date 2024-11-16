package com.quispe.alonso.laboratoriocalificado03

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class TeacherAdapter(
    private val onClick: (Teacher, String) -> Unit
) : RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder>() {

    private val teachers = mutableListOf<Teacher>()

    fun submitList(newTeachers: List<Teacher>) {
        teachers.clear()
        teachers.addAll(newTeachers)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_teacher, parent, false)
        return TeacherViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        val teacher = teachers[position]
        holder.bind(teacher, onClick)
    }

    override fun getItemCount(): Int = teachers.size

    class TeacherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val emailTextView: TextView = itemView.findViewById(R.id.emailTextView)
        private val phoneTextView: TextView = itemView.findViewById(R.id.phoneTextView)
        private val photoImageView: ImageView = itemView.findViewById(R.id.photoImageView)

        fun bind(teacher: Teacher, onClick: (Teacher, String) -> Unit) {
            nameTextView.text = "${teacher.name} ${teacher.last_name}"
            emailTextView.text = teacher.email
            phoneTextView.text = teacher.phone_number
            Glide.with(itemView.context).load(teacher.image_url).into(photoImageView)

            itemView.setOnClickListener { onClick(teacher, "call") }
            itemView.setOnLongClickListener {
                onClick(teacher, "email")
                true
            }
        }
    }
}
