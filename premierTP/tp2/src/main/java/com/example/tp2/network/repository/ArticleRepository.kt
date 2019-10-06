package com.example.tp2.network.repository

import com.example.tp2.adaptateur.Article
import com.example.tp2.network.ArticleService
import retrofit2.Retrofit

class ArticleRepository (){
    private val service: ArticleService
    init {
        val retrofit = Retrofit.Builder().apply {
            baseUrl("[URL]")
        }.build()
        service = retrofit.create(ArticleService::class.java)
    }
    fun list(): List<Article> {
        val response =  service.list().execute()
        return response.body() ?: emptyList()
    }
}
