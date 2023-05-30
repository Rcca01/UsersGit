package com.example.projectteste.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectteste.models.User
import com.example.projectteste.repositories.UserRepository
import kotlinx.coroutines.launch
import java.io.IOException

class UserViewModel(
    private val userRepository: UserRepository,
): ViewModel() {

    private val listMutUsers: MutableLiveData<List<User>> = MutableLiveData()
    fun listUsers(): LiveData<List<User>> = listMutUsers

    private val statusMutError:MutableLiveData<String> = MutableLiveData()
    fun statusError():LiveData<String> = statusMutError

    fun getAllUsers() = viewModelScope.launch {
        try {
            val responseListUsers = userRepository.getAllUsers()
            if(responseListUsers.isNotEmpty())
                listMutUsers.postValue(responseListUsers)
            else
                statusMutError.postValue("Lista vazia")
        } catch (exception: IOException){
            statusMutError.postValue("Erro ao realizar a request")
        }

    }
}