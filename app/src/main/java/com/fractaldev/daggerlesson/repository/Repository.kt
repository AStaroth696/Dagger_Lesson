package com.fractaldev.daggerlesson.repository

import com.fractaldev.daggerlesson.database.User

interface Repository {

    suspend fun getUsers(): List<User>

}