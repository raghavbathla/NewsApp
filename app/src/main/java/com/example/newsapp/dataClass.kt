package com.example.newsapp

import java.sql.Array

data class RecycleDta(val articles: List<dataClass>)
data class dataClass (
    val description:String,
    val url:String,
    val urlToImage: String,
   val title: String,
    )
