package com.example.newsappf.Api

import com.example.newsappf.Util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsInstance {
    companion object{
        val newsInstancess : NewsAPi
        init {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            newsInstancess = retrofit.create(NewsAPi::class.java)
        }
    }
}