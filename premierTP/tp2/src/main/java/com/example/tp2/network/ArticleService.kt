package com.example.tp2.network

import com.example.tp2.models.Article
import com.example.tp2.models.ArticleResponse
import retrofit2.Call
import retrofit2.http.GET

interface ArticleService {

    @GET("everything?q=*&sortBy=publishedAt&apiKey=ad6ca712b4b1427f884f987a58c8ed3a")
    fun list(): Call<ArticleResponse>
}