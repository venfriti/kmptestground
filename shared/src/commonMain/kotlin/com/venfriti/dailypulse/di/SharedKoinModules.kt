package com.venfriti.dailypulse.di

import com.venfriti.dailypulse.articles.di.articlesModule


val sharedKoinModules = listOf(
    articlesModule,
    networkModule
)