package com.sidrakotlin.roomdatabase.`interface`

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sidrakotlin.roomdatabase.models.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAllUsers():List<User>?

    @Insert
     fun insertData(user:User)

    @Delete
     fun deleteUser(user:User)

    @Update
     fun updateUser(user: User)

    @Query("DELETE FROM user")
     fun deleteAll():List<User>?
}