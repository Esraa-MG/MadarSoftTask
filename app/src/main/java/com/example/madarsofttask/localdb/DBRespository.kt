package com.example.madarsofttask.localdb

import androidx.lifecycle.LiveData

class DBRespository (private var db: UserDatabase){

    fun insert(user: User){
        Thread(
            Runnable {
                db.userDao().insertAll(user)
            }
        ).start()
    }

    fun getAll(): LiveData<List<User>>{
       return db.userDao().getAll()
    }
}