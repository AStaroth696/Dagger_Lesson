package com.fractaldev.daggerlesson.di.viewmodel.main

import com.fractaldev.daggerlesson.ui.main.MainViewModel
import dagger.Subcomponent

@Subcomponent
interface MainViewModelComponent {

    val viewModel: MainViewModel

    @Subcomponent.Factory
    interface Factory {

        fun create(): MainViewModelComponent

    }

}