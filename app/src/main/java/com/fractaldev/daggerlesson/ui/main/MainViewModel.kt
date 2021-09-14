package com.fractaldev.daggerlesson.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fractaldev.daggerlesson.database.User
import com.fractaldev.daggerlesson.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: Repository
) : ViewModel() {

    private val mutableUsers = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = mutableUsers

    fun test() {
        viewModelScope.launch {
            mutableUsers.postValue(repository.getUsers())
        }

    }

}