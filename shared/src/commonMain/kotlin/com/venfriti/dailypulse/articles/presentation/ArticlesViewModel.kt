package com.venfriti.dailypulse.articles.presentation

import com.venfriti.dailypulse.BaseViewModel
import com.venfriti.dailypulse.articles.application.ArticlesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val useCase: ArticlesUseCase
) : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(loading = true))

    val articlesState: StateFlow<ArticlesState>
        get() = _articlesState

    init {
        getArticles()
    }

    fun getArticles(
        forceFetch: Boolean = false
    ) {
        scope.launch {
            _articlesState.emit(ArticlesState(loading = true, articles = _articlesState.value.articles))

            val fetchedArticles = useCase.getArticles(forceFetch)
            _articlesState.emit(ArticlesState(fetchedArticles))
        }
    }

}