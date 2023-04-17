package com.example.newsappf.Api

import com.example.newsappf.Model.NewsModel
import com.example.newsappf.Model.Source
import com.example.newsappf.Util.Constants.Companion.API_KEY
import com.example.newsappf.Util.Constants.Companion.BASE_URL
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import javax.security.auth.callback.Callback

interface NewsAPi {

        @GET("v2/top-headlines?apiKey=$API_KEY")
        fun getHeadlines(@Query("country") country: String, @Query("page") page: Int): Call<NewsModel>
    }

    object NewsSrevice{
        val newsInstance : NewsAPi
        init {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            newsInstance = retrofit.create(NewsAPi::class.java)
        }
    }


