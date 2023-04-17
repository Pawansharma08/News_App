package com.example.newsappf.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsappf.Model.Article
import com.example.newsappf.R

class NewsAdapter(val context: Context?, val article: List<Article>):RecyclerView.Adapter<NewsAdapter.NewsAdapterViewHolder>(){

    class NewsAdapterViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
            val newsName =itemView.findViewById<TextView>(R.id.tvTitle)
            val newsDes =itemView.findViewById<TextView>(R.id.tvDescription)
//            val newsPublish =itemView.findViewById<TextView>(R.id.tvPublishedAt)
//            val newsSource =itemView.findViewById<TextView>(R.id.tvSource)
            val newsImage = itemView.findViewById<ImageView>(R.id.ivArticleImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapterViewHolder {
        val view =LayoutInflater.from(context).inflate(R.layout.item_article_preview,parent,false)
        return NewsAdapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  article.size
    }

    override fun onBindViewHolder(holder: NewsAdapterViewHolder, position: Int) {
            val articles = article[position]
            holder.newsName.text = articles.title
            holder.newsDes.text = articles.description
//            holder.newsPublish.text = articles.publishedAt
//            holder.newsSource.text = articles.source.toString()
        if (context != null) {
            Glide.with(context).load(articles.urlToImage).into(holder.newsImage)
        }
            holder.itemView.setOnClickListener{
                Toast.makeText(context,articles.title,Toast.LENGTH_SHORT).show()
            }
    }
}