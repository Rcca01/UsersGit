package com.example.projectteste.di

import com.example.projectteste.modules.apiModule
import com.example.projectteste.modules.repositoriesModule
import org.koin.core.module.Module

val listModules = listOf<Module>(
    apiModule,
    repositoriesModule
)