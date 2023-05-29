package com.example.projectteste.modules

import com.example.projectteste.api.UserApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {
    single { provideUserApi() }
}

fun provideUserApi() : UserApi {
    return Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(UserApi::class.java)
}