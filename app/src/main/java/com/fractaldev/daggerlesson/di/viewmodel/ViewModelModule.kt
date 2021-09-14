package com.fractaldev.daggerlesson.di.viewmodel

import android.content.Context
import com.fractaldev.daggerlesson.di.data.DataModule
import com.fractaldev.daggerlesson.di.data.RepositoryBindsModule
import com.fractaldev.daggerlesson.di.viewmodel.details.DetailsViewModelComponent
import dagger.Module
import dagger.Provides

@Module(
    subcomponents = [DetailsViewModelComponent::class],
    includes = [DataModule::class, RepositoryBindsModule::class]
)
class ViewModelModule(private val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

}