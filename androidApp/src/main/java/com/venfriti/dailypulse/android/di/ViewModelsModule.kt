package com.venfriti.dailypulse.android.di

import com.venfriti.dailypulse.articles.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel {
        ArticlesViewModel(get())
    }
}