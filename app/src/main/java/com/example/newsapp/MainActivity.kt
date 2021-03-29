package com.example.newsapp

import android.graphics.drawable.ClipDrawable.VERTICAL
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.ViewModel.RecyclerActivityViewModel
import com.example.newsapp.network.apiCall
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var recyclerViewAdapters: recyclerViewAdapter
lateinit var progress: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
progress = findViewById(R.id.progress)

        recycleGet()
     getList()


    }


    private fun recycleGet() {
        val recycler: RecyclerView = findViewById(R.id.recycle)
        recycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerViewAdapters = recyclerViewAdapter()
            adapter = recyclerViewAdapters

        }
    }

private fun getList(){


val viewModel = ViewModelProviders.of(this).get(RecyclerActivityViewModel::class.java)

        viewModel.getRecycleObserverListListner().observe(this, Observer<RecycleDta?> {
            if(it != null){
                recyclerViewAdapters.setListData(it.articles as ArrayList<dataClass>)
                Log.i("data",it.articles.toString())
                recyclerViewAdapters.notifyDataSetChanged()

            }
            else{
                Toast.makeText(this,"API Limit Reached",Toast.LENGTH_LONG).show()

            }
            progress.visibility = View.INVISIBLE
        })
        viewModel.makeApiCall()

    }

}
