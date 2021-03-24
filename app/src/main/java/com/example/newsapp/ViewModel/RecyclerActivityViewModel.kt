package com.example.newsapp.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.RecycleDta
import com.example.newsapp.dataClass
import com.example.newsapp.network.apiCall
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecyclerActivityViewModel : ViewModel() {
    val baseUrl = "https://newsapi.org/"
lateinit var recyclerListData : MutableLiveData<RecycleDta>


init {
    recyclerListData = MutableLiveData()
}

    fun getRecycleObserverListListner() : MutableLiveData<RecycleDta>
    {
        return recyclerListData
    }


    fun makeApiCall(){
        val api = getRetrofit().create(apiCall::class.java)
        val post= api.getNews()
        post.enqueue(object : Callback<RecycleDta> {
            override fun onResponse(call: Call<RecycleDta>, response: Response<RecycleDta>) {
                if (response.isSuccessful){
                 //   recyclerViewAdapters.setListData(response.body()?.articles!! as ArrayList<dataClass>)
                   // recyclerViewAdapters.notifyDataSetChanged()

                    recyclerListData.postValue(response.body())
                    Log.i("dta",response.body().toString())
                    Log.i("data2,",response.body()?.articles.toString())


                }
                else
                {
               recyclerListData.postValue(null)
                }
            }

            override fun onFailure(call: Call<RecycleDta>, t: Throwable) {
                Log.i("Error",t.message.toString())
          //      recyclerListData.postValue(null)
            }


        })

    }
    private fun getRetrofit() = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(
        GsonConverterFactory.create()).build()
}