package com.venfriti.dailypulse.articles.presentation

import com.venfriti.dailypulse.articles.application.Article

data class ArticlesState (
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)
