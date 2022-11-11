package com.kshitij.retrofit.services

import com.kshitij.retrofit.models.UsersResponse
import com.kshitij.retrofit.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

class MyClient {
    var api:ApiInterface
    init {
        val httpInterceptor = HttpLoggingInterceptor()
        httpInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(httpInterceptor)
            .readTimeout(60,TimeUnit.SECONDS)
            .connectTimeout(60,TimeUnit.SECONDS)
            .writeTimeout(60,TimeUnit.SECONDS).build()

        val retrofitt = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(client)
            .baseUrl(Constants.baseUrl).build()
            api =  retrofitt.create(ApiInterface::class.java)
    }

    interface ApiInterface{
         @GET("users")
         fun fetchDetails(): Call<ArrayList<UsersResponse>>

        @GET("users/{id}")
        fun fetchSingleDetails(@Path("id") id:Int): Call<UsersResponse>
    }

}