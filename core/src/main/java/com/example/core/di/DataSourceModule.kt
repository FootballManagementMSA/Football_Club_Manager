package com.example.core.di

import com.example.core.datasource.TestDataSource
import com.example.core.datasource.TestDataSourceImpl
import com.example.core.datasource.UserDataSource
import com.example.core.datasource.UserLocalDataSourceImpl
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
    abstract fun bindsUserDataSource(userLocalDataSourceImpl: UserLocalDataSourceImpl): UserDataSource
}