package com.venfriti.dailypulse.di

import app.cash.sqldelight.db.SqlDriver
import com.venfriti.dailypulse.db.DatabaseDriverFactory
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }

    single<DaillyPulseDatabase> { DailyPulseDatabase(get())}
}