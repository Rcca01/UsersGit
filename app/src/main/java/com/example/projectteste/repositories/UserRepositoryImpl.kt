package com.example.projectteste.repositories

import com.example.projectteste.api.UserApi
import com.example.projectteste.models.User

class UserRepositoryImpl(
    private val userAPI: UserApi
) : UserRepository {

    override suspend fun getAllUsers(): List<User> = userAPI.getAllUsers()

}