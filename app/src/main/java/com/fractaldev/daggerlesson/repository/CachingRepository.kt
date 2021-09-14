package com.fractaldev.daggerlesson.repository

import com.fractaldev.daggerlesson.database.User
import com.fractaldev.daggerlesson.di.DATABASE
import com.fractaldev.daggerlesson.di.NETWORK
import java.lang.Exception
import javax.inject.Inject

class CachingRepository @Inject constructor(
    @DATABASE
    private val databaseRepository: Repository,
    @NETWORK
    private val networkRepository: Repository
) : Repository {

    override suspend fun getUsers(): List<User> {
        return try {
            networkRepository.getUsers()
        } catch (e: Exception) {
            e.printStackTrace()
            try {
                databaseRepository.getUsers()
            } catch (e: Exception) {
                e.printStackTrace()
                listOf()
            }
        }
    }

}