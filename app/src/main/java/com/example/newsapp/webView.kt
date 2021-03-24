package com.example.newsapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.annotation.RequiresApi

class webView : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        var  web : WebView= findViewById(R.id.web) as WebView
        web.webViewClient
        val Url_web = intent.getStringExtra("URL")

        Url_web?.let { web.loadUrl(it) }
        val websetting : WebSettings = web.settings
        websetting.javaScriptEnabled



    }

//    override fun onBackPressed() {
//        if(web.canGoBack()){
//            web.goBack()
//        }
//        else{
//        super.onBackPressed()
//        }
    }

