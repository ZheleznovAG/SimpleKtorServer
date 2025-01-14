package com.example

import io.ktor.server.application.*
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureFrameworks(modules: List<org.koin.core.module.Module>) {
    install(Koin) {
        slf4jLogger()
        modules(
            listOf(
                appModule,
                authModule,
            )
        )
    }
}

val appModule = module {
    single { HelloServiceImpl() }
}

val authModule = module {
    single { AuthService() }
}