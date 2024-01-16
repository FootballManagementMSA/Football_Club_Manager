package com.example.core.di

import com.example.core.datasource.TestDataSource
import com.example.core.datasource.TestDataSourceImpl
import com.example.core.datasource.UserLocalDataSource
import com.example.core.datasource.UserLocalDataSourceImpl
import com.example.core.datasource.UserRemoteDataSource
import com.example.core.datasource.UserRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataSourceModule {

    @Binds
    abstract fun bindsTestDataSource(testDataSourceImpl: TestDataSourceImpl): TestDataSource

    @Binds
    abstract fun bindsUserDataSource(userLocalDataSourceImpl: UserLocalDataSourceImpl): UserLocalDataSource

    @Binds
    abstract fun bindsUserRemoteDataSource(userRemoteDataSourceImpl: UserRemoteDataSourceImpl): UserRemoteDataSource
}