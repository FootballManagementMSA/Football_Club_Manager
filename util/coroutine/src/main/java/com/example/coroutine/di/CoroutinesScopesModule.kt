package com.example.coroutine.di

import com.example.coroutine.ComputingScope
import com.example.coroutine.DefaultDispatcher
import com.example.coroutine.IoDispatcher
import com.example.coroutine.MainDispatcher
import com.example.coroutine.NetworkingScope
import com.example.coroutine.UIScope
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CoroutinesScopesModule {

    @Provides
    @Singleton
    @NetworkingScope
    fun providesNetworkingScope(
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): CoroutineScope = CoroutineScope(SupervisorJob() + ioDispatcher)

    @Provides
    @Singleton
    @ComputingScope
    fun providesComputingScope(
        @DefaultDispatcher defaultDispatcher: CoroutineDispatcher
    ): CoroutineScope = CoroutineScope(SupervisorJob() + defaultDispatcher)

    @Provides
    @Singleton
    @UIScope
    fun providesUIScope(
        @MainDispatcher mainDispatcher: CoroutineDispatcher
    ): CoroutineScope = CoroutineScope(SupervisorJob() + mainDispatcher)
}