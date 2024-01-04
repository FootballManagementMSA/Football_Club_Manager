package com.example.network.di

import com.example.network.network.TestApi
import com.example.network.network.TestApiImpl
import com.example.network.repository.TestRepositoryImpl
import com.example.network_api.repository.TestRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DummyApiModule {
    @Binds
    abstract fun bindsDummy(testApiImpl: TestApiImpl) : TestApi

    @Binds
    abstract fun bindsTestRepository(testRepositoryImpl: TestRepositoryImpl) : TestRepository
}