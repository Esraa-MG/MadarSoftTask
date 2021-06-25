package com.example.madarsofttask

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.madarsofttask.localdb.DBRespository
import com.example.madarsofttask.localdb.User

import com.example.madarsofttask.localdb.UserDatabase
import com.example.madarsofttask.viewmodel.UserViewModel

class FirstScreen : AppCompatActivity() {

    companion object{
        lateinit var  roomDatabase: UserDatabase
    }

    lateinit var nameTxt: EditText
    lateinit var jobTxt: EditText
    lateinit var ageTxt: EditText
    lateinit var saveBtn: Button
    lateinit var genderSpinner: Spinner

    lateinit var userViewModel : UserViewModel
    lateinit var userRepo: DBRespository

    val gender = arrayOf("Gender","Female","Male")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_screen)

        nameTxt = findViewById(R.id.first_screen_name_txt)
        jobTxt = findViewById(R.id.first_screen_job_txt)
        ageTxt = findViewById(R.id.first_screen_age_txt)
        genderSpinner = findViewById(R.id.first_screen_spinner)
        saveBtn = findViewById(R.id.first_screen_btn)

        setGenderSpinner()

        roomDatabase = Room.databaseBuilder(
                applicationContext,
                UserDatabase::class.java,
                "users_database.db"
        ).build()

        userRepo = DBRespository(roomDatabase)
        userViewModel = UserViewModel(userRepo)

        saveBtn.setOnClickListener {
            if (nameTxt.text.isEmpty()) {
                Toast.makeText(this, "Enter your name please", Toast.LENGTH_LONG).show()
            } else if (ageTxt.text.isEmpty()) {
                Toast.makeText(this, "Enter your age please", Toast.LENGTH_LONG).show()
            } else if (jobTxt.text.isEmpty()) {
                Toast.makeText(this, "Enter your job title please", Toast.LENGTH_LONG).show()
            }else if (genderSpinner.selectedItem == "Gender"){
                Toast.makeText(this,"Enter your gender please",Toast.LENGTH_LONG).show()
            } else{
                userViewModel.insertUser(User(nameTxt.text.toString(),jobTxt.text.toString(),ageTxt.text.toString(),genderSpinner.selectedItem.toString()))
                startActivity(Intent(this, SecondScreen::class.java))
            }
        }
    }

    private fun setGenderSpinner() {
        genderSpinner.adapter = MySpinnerAdapter<String>(
            this, android.R.layout.simple_spinner_dropdown_item,
            gender.toMutableList()
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            genderSpinner.adapter = adapter

        }

        genderSpinner.onItemSelectedListener = object : AdapterView.OnItemClickListener,
            AdapterView.OnItemSelectedListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

        }


    }
}