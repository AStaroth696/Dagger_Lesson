package com.fractaldev.daggerlesson.di.data

import android.content.Context
import androidx.room.Room
import com.fractaldev.daggerlesson.database.UserDao
import com.fractaldev.daggerlesson.database.UsersDatabase
import com.fractaldev.daggerlesson.network.UserApi
import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class DataModule {

    @Provides
    fun provideConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun provideRetrofit(converterFactory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(converterFactory)
            .baseUrl("https://some.url.com")
            .build()
    }

    @Provides
    fun provideUserApi(retrofit: Retrofit): UserApi {
        return retrofit.create(UserApi::class.java)
    }

    @Provides
    fun provideDatabase(context: Context): UsersDatabase {
        return Room.databaseBuilder(context, UsersDatabase::class.java, "users.db").build()
    }

    @Provides
    fun provideUserDao(usersDatabase: UsersDatabase): UserDao {
        return usersDatabase.usersDao()
    }

}