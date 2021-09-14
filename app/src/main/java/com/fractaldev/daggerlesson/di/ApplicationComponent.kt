package com.fractaldev.daggerlesson.di

import android.content.Context
import com.fractaldev.daggerlesson.di.viewmodel.ViewModelComponent
import com.fractaldev.daggerlesson.ui.MainActivity
import com.fractaldev.daggerlesson.ui.details.DetailsFragment
import com.fractaldev.daggerlesson.ui.main.MainFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [
        ViewModelComponent::class
    ]
)
@Singleton
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        fun viewModelComponent(viewModelComponent: ViewModelComponent): Builder

        fun build(): ApplicationComponent

    }

    fun context(): Context

    fun inject(activity: MainActivity)

    fun inject(fragment: MainFragment)

    fun inject(fragment: DetailsFragment)

}