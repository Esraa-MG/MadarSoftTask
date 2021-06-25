package com.example.madarsofttask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.madarsofttask.localdb.DBRespository
import com.example.madarsofttask.localdb.User

class UserViewModel(private var userRepo: DBRespository): ViewModel() {

    fun insertUser(user: User) = this.userRepo.insert(user)

    fun getAllUsers(): LiveData<List<User>> {
        return this.userRepo.getAll()
    }
}