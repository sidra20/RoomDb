package com.sidrakotlin.roomdatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sidrakotlin.roomdatabase.`interface`.UserDao
import com.sidrakotlin.roomdatabase.models.User

@Database(entities = [User::class], version = 1)
abstract class MyDb : RoomDatabase() {

    abstract fun userDao():UserDao

    companion object
    {
        private var instance:MyDb?=null

        fun getDb(context:Context):MyDb
        {
            if(instance==null)
            {
                synchronized(this)
                {
                    instance = Room.databaseBuilder(context.applicationContext,
                        MyDb::class.java,
                    "mydb")
                        .build()
                }
            }
            return instance!!
        }
    }
}