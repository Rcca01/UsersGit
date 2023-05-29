package com.example.projectteste.modules

import com.example.projectteste.repositories.UserRepository
import com.example.projectteste.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { provideUserViewModel(get()) }
}

fun provideUserViewModel(userRepository: UserRepository): UserViewModel {
    return UserViewModel(
        userRepository = userRepository
    )
}