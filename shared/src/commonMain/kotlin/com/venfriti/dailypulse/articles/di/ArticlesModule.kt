package com.venfriti.dailypulse.articles.di

import com.venfriti.dailypulse.articles.ArticlesService
import com.venfriti.dailypulse.articles.ArticlesUseCase
import com.venfriti.dailypulse.articles.ArticlesViewModel
import org.koin.dsl.module


val articlesModule = module {

    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }

}