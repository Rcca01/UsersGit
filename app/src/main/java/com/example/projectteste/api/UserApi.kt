package com.example.projectteste.api

import com.example.projectteste.models.User
import retrofit2.http.GET

interface UserApi {
    @GET("/users")
    suspend fun getAllUsers() : List<User>
}