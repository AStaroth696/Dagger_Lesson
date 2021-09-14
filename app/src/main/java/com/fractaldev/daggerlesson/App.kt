package com.fractaldev.daggerlesson

import android.app.Application
import com.fractaldev.daggerlesson.di.ApplicationComponent
import com.fractaldev.daggerlesson.di.DaggerApplicationComponent
import com.fractaldev.daggerlesson.di.data.DataModule
import com.fractaldev.daggerlesson.di.viewmodel.DaggerViewModelComponent
import com.fractaldev.daggerlesson.di.viewmodel.ViewModelModule

class App : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        val viewModelComponent = DaggerViewModelComponent.builder()
            .viewModelModule(ViewModelModule(this))
            .dataModule(DataModule())
            .build()
        applicationComponent = DaggerApplicationComponent.builder()
            .withContext(this)
            .viewModelComponent(viewModelComponent)
            .build()
    }

}