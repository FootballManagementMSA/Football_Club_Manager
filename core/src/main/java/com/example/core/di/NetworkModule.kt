package com.example.core.di

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.core.BASE_URL
import com.example.core.userDataStore
import com.example.network_api.api.FootballManagerApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideInterceptor(@ApplicationContext context: Context): Interceptor {

        return Interceptor { chain: Interceptor.Chain ->
            runBlocking {
                val key = stringPreferencesKey("ACEESS_TOKEN")
                val accessToken: String = context.userDataStore.data.first()[key] ?: ""
                val newRequest: Request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer $accessToken")
                    .build()
                chain.proceed(newRequest)
            }
        }
    }
    @Provides
    @Singleton
    fun provideOkHttpClient(
        interceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(10, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(15, TimeUnit.SECONDS)
//            addInterceptor(httpLoggingInterceptor)
            addInterceptor(interceptor)
            // authenticator(tokenAuthenticator)
        }.build()
    }
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun provideFootballManagerApi(retrofit: Retrofit): FootballManagerApi {
        return retrofit.create(FootballManagerApi::class.java)
    }
}