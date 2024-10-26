package com.venfriti.dailypulse.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver

actual class DatabaseDriverFactory() {

    actual fun createDriver(): SqlDriver =
        NativeSqliteDriver(
            schema = DailyPulseDatabase.Schema,
            name = "DailyPulseDatabase.db"
        )


}