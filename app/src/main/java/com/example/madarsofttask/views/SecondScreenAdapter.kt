package com.example.madarsofttask.views

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.madarsofttask.R
import com.example.madarsofttask.localdb.User

class SecondScreenAdapter(private val userList: List<User>) :
    RecyclerView.Adapter<SecondScreenAdapter.UserViewHolder>() {

    lateinit var context: Context

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameLbl = itemView.findViewById<TextView>(R.id.second_screen_name_lbl)
        var ageLbl = itemView.findViewById<TextView>(R.id.second_screen_age_lbl)
        var jobLbl = itemView.findViewById<TextView>(R.id.second_screen_job_lbl)
        var genderLbl = itemView.findViewById<TextView>(R.id.second_screen_gender_lbl)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_row, parent, false)
        context = parent.context
        return UserViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.nameLbl.text = "name : ${currentItem.name}"
        holder.ageLbl.text = "age : ${currentItem.age}"
        holder.genderLbl.text = "gender : ${currentItem.gender}"
        holder.jobLbl.text = "job title : ${currentItem.jobTitle}"

    }

    override fun getItemCount() = userList.size


}