package com.example.newsapp.network

import com.example.newsapp.R
import com.example.newsapp.RecycleDta
import com.example.newsapp.dataClass
import retrofit2.Call
import retrofit2.http.GET

interface apiCall {
    @GET("v2/everything?q=tesla&from=2021-02-24&sortBy=publishedAt&apiKey=1af45281785540b4894e3c698b741c3d")
    fun getNews() : Call<RecycleDta>
}