package com.fractaldev.daggerlesson.repository

import com.fractaldev.daggerlesson.database.User
import com.fractaldev.daggerlesson.database.UserDao
import javax.inject.Inject

class DatabaseRepository @Inject constructor(
    private val userDao: UserDao
) : Repository {

    override suspend fun getUsers(): List<User> {
        return userDao.getAll()
    }

}