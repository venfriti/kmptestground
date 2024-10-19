package com.venfriti.dailypulse.articles

import com.venfriti.dailypulse.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(loading = true))

    val articleState: StateFlow<ArticlesState>
        get() = _articlesState


    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch {


            val fetchedArticles = fetchArticles()
            delay(500)
            _articlesState.emit(ArticlesState(fetchedArticles))
        }
    }

    suspend fun fetchArticles() : List<Article> = mockArticles

    private val mockArticles = listOf(
        Article(
            "Stock market today: Live updates - CNBC",
            "Futures were higher in premarket trading as Wall Street tried to regain its footing.",
            "2023-11-09",
            ""
        ),
        Article(
            "Best iPhone Deals (2023): Carrier Deals, Unlocked iPhones",
            "Apple's smartphones rarely go on sale, but if you're looking to upgrade (or you're gift shopping), here are.",
            "2023-11-09",
            ""
        ),
        Article(
            "Samsung details 'Galaxy AI' and a feature that can translate phone calls in real time",
            "In a new blog post, Samsung previewed what it calls 'a new era of Galaxy AI' coming to its smartphones and",
            "2023-11-09",
            ""
        )
    )
}