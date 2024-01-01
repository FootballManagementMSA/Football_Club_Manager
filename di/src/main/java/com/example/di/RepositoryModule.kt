package com.example.di

import com.example.core.datasource.TestDataSource
import com.example.core.datasource.TestDataSourceImpl
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
abstract class RepositoryModule {
    @Binds
    abstract fun bindsDummy(testApiImpl: TestApiImpl) : TestApi

    @Binds
    abstract fun bindsTestRepository(testRepositoryImpl: TestRepositoryImpl): TestRepository

    @Binds
    abstract fun bindsTestDataSource(testDataSourceImpl: TestDataSourceImpl) : TestDataSource
}