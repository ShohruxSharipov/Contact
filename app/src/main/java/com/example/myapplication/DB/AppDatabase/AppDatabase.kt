package com.example.myapplication.DB.AppDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.DB.ContactDao.ContactDao
import com.example.myapplication.DB.Entity.ContactEn

@Database(entities = [ContactEn::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun getContactDao():ContactDao

    companion object{
        var instanse : AppDatabase? = null

        fun getInstanse(context:Context):AppDatabase{
            if (instanse == null){
                instanse = Room.databaseBuilder(context,AppDatabase::class.java,"app_db")
                    .allowMainThreadQueries()
                    .build()
            }
            return instanse!!
        }
    }
}