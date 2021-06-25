package com.example.madarsofttask.localdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(

    @ColumnInfo(name = "name") var name: String?,
    @ColumnInfo(name = "jobtitle") var jobTitle: String?,
    @ColumnInfo(name = "age") var age: String?,
    @ColumnInfo(name = "gender") var gender: String?
){
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}

