package com.fractaldev.daggerlesson.di.data

import com.fractaldev.daggerlesson.di.DATABASE
import com.fractaldev.daggerlesson.di.NETWORK
import com.fractaldev.daggerlesson.repository.CachingRepository
import com.fractaldev.daggerlesson.repository.DatabaseRepository
import com.fractaldev.daggerlesson.repository.NetworkRepository
import com.fractaldev.daggerlesson.repository.Repository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryBindsModule {

    @Binds
    @DATABASE
    abstract fun bindDatabaseRepository(impl: DatabaseRepository): Repository

    @Binds
    @NETWORK
    abstract fun bindNetworkRepository(impl: NetworkRepository): Repository

    @Binds
    abstract fun bindCachingRepository(impl: CachingRepository): Repository

}