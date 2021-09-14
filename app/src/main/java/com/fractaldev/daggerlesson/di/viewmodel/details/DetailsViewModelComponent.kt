package com.fractaldev.daggerlesson.di.viewmodel.details

import com.fractaldev.daggerlesson.di.data.RepositoryBindsModule
import com.fractaldev.daggerlesson.ui.details.DetailsViewModel
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [DetailsViewModelModule::class])
interface DetailsViewModelComponent {

    val viewModel: DetailsViewModel

    @Subcomponent.Factory
    interface Factory {

        fun create(@BindsInstance userId: Int): DetailsViewModelComponent

    }

}