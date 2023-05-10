package com.example.myapplication.DB.ContactDao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.DB.Entity.ContactEn

@Dao
interface ContactDao {

    @Query("select * from ContactEn")
    fun getAll():List<ContactEn>

    @Insert
    fun addContact(contactEn: ContactEn)
}