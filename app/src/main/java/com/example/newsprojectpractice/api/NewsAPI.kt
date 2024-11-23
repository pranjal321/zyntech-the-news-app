package com.example.newsprojectpractice.api

import com.example.newsprojectpractice.models.NewsResponse
import com.example.newsprojectpractice.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/top-headlines")
    abstract suspend fun getHeadlines(
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>

    @GET("v2/everything")
    abstract suspend fun searchForNews(
         @Query("q")
         searchQuery: String,
         @Query("page")
         pageNumber: Int = 1,
         @Query("apiKey")
         apiKey: String = API_KEY
     ): Response<NewsResponse>
}