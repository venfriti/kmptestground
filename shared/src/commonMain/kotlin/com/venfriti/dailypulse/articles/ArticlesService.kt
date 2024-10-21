package com.venfriti.dailypulse.articles

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(private val httpClient: HttpClient) {

    private val country = "us"
    private val category = "business"
    private val apiKey = "1eb4a5c87d004b978d7fd0d2f7d690f6"

    suspend fun fetchArticles(): List<ArticleRaw> {
        val response: ArticlesResponse = httpClient
            .get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey").body()

        return response.articles
    }
}