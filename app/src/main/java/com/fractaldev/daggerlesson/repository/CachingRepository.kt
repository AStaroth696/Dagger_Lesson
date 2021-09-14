package com.fractaldev.daggerlesson.repository

import com.fractaldev.daggerlesson.database.User
import java.lang.Exception

class CachingRepository(
    private val databaseRepository: Repository,
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