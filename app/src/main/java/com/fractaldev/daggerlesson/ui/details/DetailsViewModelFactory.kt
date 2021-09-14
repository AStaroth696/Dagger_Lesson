package com.fractaldev.daggerlesson.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fractaldev.daggerlesson.di.viewmodel.details.DetailsViewModelComponent

class DetailsViewModelFactory(
    private val userId: Int,
    private val factory: DetailsViewModelComponent.Factory
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return factory.create(userId).viewModel as T
    }

}