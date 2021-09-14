package com.fractaldev.daggerlesson.repository

import com.fractaldev.daggerlesson.database.User
import com.fractaldev.daggerlesson.network.UserApi

class NetworkRepository(
    private val userApi: UserApi
) : Repository {

    override suspend fun getUsers(): List<User> {
        return userApi.getAllUsers()
    }

}