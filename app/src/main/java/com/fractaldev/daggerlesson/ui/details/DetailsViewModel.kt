package com.fractaldev.daggerlesson.ui.details

import androidx.lifecycle.ViewModel
import com.fractaldev.daggerlesson.repository.Repository

class DetailsViewModel(
    private val repository: Repository,
    private val userId: Int
) : ViewModel() {

    fun detailsTest() {
        println("test___ userId: $userId")
    }

}