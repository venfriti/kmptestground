package com.venfriti.dailypulse

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform