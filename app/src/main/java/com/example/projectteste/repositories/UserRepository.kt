package com.example.projectteste.repositories

import com.example.projectteste.models.User

interface UserRepository {

    suspend fun getAllUsers() : List<User>

}