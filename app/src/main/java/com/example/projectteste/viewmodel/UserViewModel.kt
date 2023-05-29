package com.example.projectteste.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectteste.repositories.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(
    private val userRepository: UserRepository,
): ViewModel() {

    fun getAllUsers() = viewModelScope.launch {

        val users = userRepository.getAllUsers()

    }
}