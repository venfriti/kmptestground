package com.venfriti.dailypulse.android

import android.app.Application
import com.venfriti.dailypulse.android.di.databaseModule
import com.venfriti.dailypulse.android.di.viewModelsModule
import com.venfriti.dailypulse.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class DailyPulseApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModules + viewModelsModule = databaseModule

        startKoin {
            androidContext(this@DailyPulseApp)
            modules(modules)
        }
    }
}