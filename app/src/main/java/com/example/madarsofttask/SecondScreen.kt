package com.example.madarsofttask

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madarsofttask.localdb.DBRespository
import com.example.madarsofttask.localdb.User
import com.example.madarsofttask.viewmodel.UserViewModel


class SecondScreen : AppCompatActivity() {

    lateinit var userViewModel : UserViewModel
    lateinit var userRepo: DBRespository

    lateinit var users : List<User>
    private lateinit var adapter : SecondScreenAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        userRepo = DBRespository(FirstScreen.roomDatabase)
        userViewModel = UserViewModel(userRepo)

        users = ArrayList<User>()
        recyclerView = findViewById(R.id.second_screen_recycler_view)



        userViewModel.getAllUsers().observe(this,  Observer<List<User>> {users ->

            for (user in users){
                (this.users as ArrayList<User>).add(
                    user)

            }
            Log.i("TAG", "onCreate: $users")
            adapter = SecondScreenAdapter(this.users)
            recyclerView.adapter = adapter

        })
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                DividerItemDecoration.VERTICAL
            )
        )
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)




    }
}