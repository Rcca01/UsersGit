package com.example.projectteste.modules

import com.example.projectteste.api.UserApi
import com.example.projectteste.repositories.UserRepository
import com.example.projectteste.repositories.UserRepositoryImpl
import org.koin.dsl.module

val repositoriesModule = module {
    single<UserRepository> { provideUserRepository(get()) }
}

fun provideUserRepository(userApi: UserApi): UserRepositoryImpl {
    return UserRepositoryImpl(
        userAPI = userApi
    )
}