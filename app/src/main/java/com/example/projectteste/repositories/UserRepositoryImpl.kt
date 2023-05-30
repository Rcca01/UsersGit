package com.example.projectteste.repositories

import com.example.projectteste.api.UserApi
import com.example.projectteste.models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepositoryImpl(
    private val userAPI: UserApi
) : UserRepository {
    override suspend fun getAllUsers(): List<User> =
        withContext(Dispatchers.IO){
            userAPI.getAllUsers()
        }

}