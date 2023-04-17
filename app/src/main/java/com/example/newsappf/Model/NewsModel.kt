package com.example.newsappf.Model

import com.example.newsappf.Model.Article

data class NewsModel(
    val articles: List<Article>,
    val totalResults: Int
)