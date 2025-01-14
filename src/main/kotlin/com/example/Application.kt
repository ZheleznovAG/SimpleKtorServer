package com.example

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080) {
        module()
    }.start(wait = true)
}

fun Application.module(koinModules: List<org.koin.core.module.Module> = listOf(appModule)) {
    configureFrameworks(koinModules)
    configureAuthentication()
    configureRouting()
}