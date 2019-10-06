package com.example.tp2.network.repository

import com.example.tp2.models.ArticleResponse
import com.example.tp2.network.ArticleService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArticleRepository {
    private val service: ArticleService
    private val baseUrl = "https://newsapi.org/v2/"

    init {
        var retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(ArticleService::class.java)
    }

    fun list(): ArticleResponse {
        val response = service.list().execute()
        return response.body() ?: ArticleResponse("", 0, ArrayList())
    }
}
