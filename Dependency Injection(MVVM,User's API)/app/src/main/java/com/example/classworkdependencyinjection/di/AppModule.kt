package com.example.classworkdependencyinjection.di

import com.example.classworkdependencyinjection.network.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    val baseUrl = " https://jsonplaceholder.typicode.com/"


    @Singleton
    @Provides
    fun getApiInstance(retrofit: Retrofit): Api{
        return retrofit.create(Api::class.java)
    }


    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}