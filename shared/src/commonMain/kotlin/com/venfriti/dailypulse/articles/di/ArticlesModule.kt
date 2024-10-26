package com.venfriti.dailypulse.articles.di

import com.venfriti.dailypulse.articles.data.ArticlesDataSource
import com.venfriti.dailypulse.articles.data.ArticlesRepository
import com.venfriti.dailypulse.articles.data.ArticlesService
import com.venfriti.dailypulse.articles.application.ArticlesUseCase
import com.venfriti.dailypulse.articles.presentation.ArticlesViewModel
import org.koin.dsl.module


val articlesModule = module {

    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }

}