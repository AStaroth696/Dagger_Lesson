package com.fractaldev.daggerlesson.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fractaldev.daggerlesson.di.viewmodel.main.MainViewModelComponent

class MainViewModelFactory(private val factory: MainViewModelComponent.Factory) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return factory.create().viewModel as T
    }
}