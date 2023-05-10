package com.example.myapplication.DB.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ContactEn(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name:String,
    var number:String
)