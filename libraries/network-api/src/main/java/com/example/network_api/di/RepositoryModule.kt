package com.example.network_api.di

import com.example.network_api.repository.MainHomeRepository
import com.example.network_api.repository.MainHomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsMainHomeRepository(mainHomeRepositoryImpl: MainHomeRepositoryImpl) : MainHomeRepository
}