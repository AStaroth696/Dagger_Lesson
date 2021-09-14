package com.fractaldev.daggerlesson.network

import com.fractaldev.daggerlesson.database.User
import retrofit2.http.GET

interface UserApi {

    @GET("users")
    suspend fun getAllUsers(): List<User>

}