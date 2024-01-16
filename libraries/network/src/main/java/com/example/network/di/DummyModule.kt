package com.example.network.di

import com.example.network.network.TestApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DummyModule {
    @Singleton
    @Provides
    fun providesTestApi() : TestApiImpl = TestApiImpl()
}