package com.fractaldev.daggerlesson.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DATABASE

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NETWORK