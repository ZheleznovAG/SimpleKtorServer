package com.example

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val helloService: HelloService by inject()
    routing {
        get("/") {
            call.respondRedirect("/hello")
        }

        get("/hello") {
            call.respondText(helloService.sayHello())
        }
    }
}
