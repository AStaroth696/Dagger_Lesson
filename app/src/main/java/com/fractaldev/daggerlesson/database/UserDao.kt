package com.fractaldev.daggerlesson.database

import androidx.room.Dao
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getAll(): List<User>

}