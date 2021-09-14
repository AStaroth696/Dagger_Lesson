package com.fractaldev.daggerlesson.di.viewmodel

import com.fractaldev.daggerlesson.di.viewmodel.details.DetailsViewModelComponent
import com.fractaldev.daggerlesson.di.viewmodel.main.MainViewModelComponent
import dagger.Component

@Component(
    modules = [
        ViewModelModule::class,
    ]
)
interface ViewModelComponent {

    fun detailsViewModelComponent(): DetailsViewModelComponent.Factory
    fun mainViewModelComponent(): MainViewModelComponent.Factory

}