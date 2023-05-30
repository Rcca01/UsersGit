package com.example.projectteste.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectteste.models.User
import com.example.projectteste.repositories.UserRepository
import com.example.projectteste.sealed.NetworkViewState
import kotlinx.coroutines.launch
import java.io.IOException

class UserViewModel(
    private val userRepository: UserRepository,
): ViewModel() {

    private val listMutUsers: MutableLiveData<NetworkViewState<List<User>>> = MutableLiveData()
    fun listUsers(): LiveData<NetworkViewState<List<User>>> = listMutUsers

    fun getAllUsers() = viewModelScope.launch {
        try {
            val responseListUsers = userRepository.getAllUsers()
            if(responseListUsers.isNotEmpty())
                listMutUsers.value = NetworkViewState.Success(responseListUsers)
            else
                listMutUsers.value =  NetworkViewState.Error("Lista vazia")
        } catch (exception: IOException){
            listMutUsers.value =  NetworkViewState.Error("Erro ao realizar a request")
        }

    }
}