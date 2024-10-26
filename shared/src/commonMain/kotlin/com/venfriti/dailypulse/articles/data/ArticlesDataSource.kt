package com.venfriti.dailypulse.articles.data

import venfriti.dailypulse.db.DailyPulseDatabase

class ArticlesDataSource(private val database: DailyPulseDatabase) {

    fun getAllArticles() : List<ArticleRaw> =
        database.dailyPulseDatabaseQueries.selectAllArticles(::)

    fun insertArticles(articles: List<ArticleRaw>) {
        database.dailyPulseDatabaseQueries.transaction {
            articles.forEach { articleRaw ->
                insertArticle(articleRaw)
            }
        }
    }

    private fun insertArticle(articleRaw: ArticleRaw) {
        database.dailyPulseDatabaseQueries.insertArticle(
            articleRaw.title,
            articleRaw.desc,
            articleRaw.date,
            articleRaw.imageUrl
        )
    }

    fun clearArticles() =
        database.dailyPulseDatabaseQueries.removeAllArticles()

    private fun mapToArticleRaw(
        title: String,
        desc: String?,
        date: String,
        url: String
    ) : ArticleRaw =
        ArticleRaw(
            title,
            desc,
            date,
            url
        )
}