package com.example.projectteste.sealed

import com.example.projectteste.models.User

sealed class NetworkViewState {
    data class Success(val data: List<User>) : NetworkViewState()
    data class Error(val message: String) : NetworkViewState()
    class Loading : NetworkViewState()
}