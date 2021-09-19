package com.example.classworkdependencyinjection.network

import com.example.classworkdependencyinjection.model.Users
import dagger.Provides
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET


interface Api {

    @GET("users")
    fun getUsers(): Call<List<Users>>
}