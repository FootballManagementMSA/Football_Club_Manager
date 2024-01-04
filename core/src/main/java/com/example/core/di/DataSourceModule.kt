package com.example.core.di

import com.example.core.datasource.TestDataSource
import com.example.core.datasource.TestDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataSourceModule {

    @Binds
    abstract fun bindsTestDataSource(testDataSourceImpl: TestDataSourceImpl): TestDataSource
}