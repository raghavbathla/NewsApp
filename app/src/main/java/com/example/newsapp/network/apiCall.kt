package com.example.newsapp.network

import com.example.newsapp.R
import com.example.newsapp.RecycleDta
import com.example.newsapp.dataClass
import retrofit2.Call
import retrofit2.http.GET

interface apiCall {
    @GET("v2/everything?q=tesla&from=2021-02-28&sortBy=publishedAt&apiKey=e1d6a895d16741f78e4fcef76c4ae36d")
    fun getNews() : Call<RecycleDta>
}