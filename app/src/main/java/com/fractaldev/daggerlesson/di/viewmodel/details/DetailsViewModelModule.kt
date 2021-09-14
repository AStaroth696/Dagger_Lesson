package com.fractaldev.daggerlesson.di.viewmodel.details

import com.fractaldev.daggerlesson.repository.Repository
import com.fractaldev.daggerlesson.ui.details.DetailsViewModel
import dagger.Module
import dagger.Provides

@Module
class DetailsViewModelModule {

    @Provides
    fun provideDetailsViewModel(
        repository: Repository,
        userId: Int
    ): DetailsViewModel {
        return DetailsViewModel(repository, userId)
    }

}