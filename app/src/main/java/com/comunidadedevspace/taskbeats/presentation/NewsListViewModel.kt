package com.comunidadedevspace.taskbeats.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.comunidadedevspace.taskbeats.data.remote.NewsDto
import com.comunidadedevspace.taskbeats.data.remote.NewsService
import com.comunidadedevspace.taskbeats.data.remote.RetrofitModule

class NewsListViewModel(
    private val newsService: NewsService
): ViewModel() {

    private val _newsListLiveData = MutableLiveData<List<NewsDto>>()
    val newsListLiveData = LiveData<List<NewsDto>> = _newsListLiveData

    fun getNewsList(){

    }
    companion object {

    fun create(): NewsListViewModel {
            val newsService = RetrofitModule.createNewsService()
            return NewsListViewModel(newsService)
        }
    }
}