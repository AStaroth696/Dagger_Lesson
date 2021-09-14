package com.fractaldev.daggerlesson.repository

import com.fractaldev.daggerlesson.database.User
import com.fractaldev.daggerlesson.network.UserApi
import javax.inject.Inject

class NetworkRepository @Inject constructor(
    private val userApi: UserApi
) : Repository {

    override suspend fun getUsers(): List<User> {
        return userApi.getAllUsers()
    }

}