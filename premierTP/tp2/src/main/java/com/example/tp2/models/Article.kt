package com.example.tp2.models

import android.media.Image

data class Article(var title: String, var description : String, var url: String, var image: String)
class ArticleResponse(val status: String, val totalResults: Int, val articles: List<Article>)