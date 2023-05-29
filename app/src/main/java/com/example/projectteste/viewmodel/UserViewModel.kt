package com.example.projectteste.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectteste.models.User
import com.example.projectteste.repositories.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(
    private val userRepository: UserRepository,
): ViewModel() {

    private val listMutUsers: MutableLiveData<List<User>> = MutableLiveData()
    fun listUsers(): LiveData<List<User>> = listMutUsers

    fun getAllUsers() = viewModelScope.launch {
        val responseListUsers = userRepository.getAllUsers()
        listMutUsers.postValue(responseListUsers)
    }
}