package com.example.newsappf.Fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.load.engine.Resource
import com.example.newsappf.Adapter.NewsAdapter
import com.example.newsappf.Api.NewsAPi
import com.example.newsappf.Api.NewsInstance
import com.example.newsappf.Api.NewsSrevice
import com.example.newsappf.Model.Article
import com.example.newsappf.Model.NewsModel
import com.example.newsappf.Model.Source
import com.example.newsappf.Util.Resources
import com.example.newsappf.ViewModel.NewsViewModel
import com.example.newsappf.databinding.FragmentBreakingNewsfragmentBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BreakingNewsfragment : Fragment() {

    private lateinit var binding: FragmentBreakingNewsfragmentBinding
    lateinit var adapter: NewsAdapter
    private var articles = mutableListOf<Article>()
    lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBreakingNewsfragmentBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = NewsAdapter(context, articles)
        binding.rvBreakingNews.adapter = adapter
        binding.rvBreakingNews.layoutManager = LinearLayoutManager(context)
        getNews()

    }

    private fun getNews() {
        val news: Call<NewsModel> = NewsSrevice.newsInstance.getHeadlines("in", 1)
        news.enqueue(object : Callback<NewsModel> {
            override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                val news: NewsModel? = response.body()
                if (news != null) {
                    Log.d("pawan", news.toString())
                    articles.addAll(news.articles)
                    adapter.notifyDataSetChanged()


                }
            }

            override fun onFailure(call: Call<NewsModel>, t: Throwable) {
                Log.d("Pawan", "Error featching News")
            }
        })
    }
}