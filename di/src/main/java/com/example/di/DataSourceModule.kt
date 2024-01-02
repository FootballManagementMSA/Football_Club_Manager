package com.example.di

import android.content.Context
import com.example.core.datasource.UserDataSource
import com.example.core.datasource.UserLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideUserDataSource(@ApplicationContext context: Context): UserDataSource {
        return UserLocalDataSourceImpl(context)
    }
}