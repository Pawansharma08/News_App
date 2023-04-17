package com.example.newsappf.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappf.Model.NewsModel
import com.example.newsappf.Repository.NewsRepo
import com.example.newsappf.Util.Resources
import kotlinx.coroutines.launch
import retrofit2.Response


class NewsViewModel(val newsRepos: NewsRepo) : ViewModel() {

    val breakingNews: MutableLiveData<Resources<NewsModel>> = MutableLiveData()
    val breakingNewsPage = 1

    init {
        getbreakingNews("in")
    }

    fun getbreakingNews(CountryCode: String) = viewModelScope.launch {

//        breakingNews.postValue(Resources.Loading())
//        val responses = newsRepos.getBreakingNew(CountryCode, breakingNewsPage)
//        breakingNews.postValue(handlerBreakingNewsResponse(responses))

    }

    private fun handlerBreakingNewsResponse(response: Response<NewsModel>): Resources<NewsModel>{
        if(response.isSuccessful){
            response.body()?.let{resultResponse->
                return Resources.Success(resultResponse)
            }
        }
        return Resources.Error(response.message())

    }
}