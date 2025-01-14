package com.example

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val helloService: HelloService by inject()
    val authService by inject<AuthService>()

    routing {
        get("/") {
            call.respondRedirect("/hello")
        }

        get("/hello") {
            call.respondText(helloService.sayHello())
        }

        authenticate("auth-oauth-google") {
            get("/login") {
                call.respondRedirect("/callback")
            }
        }

        get("/callback") {
            val principal: OAuthAccessTokenResponse.OAuth2? = call.authentication.principal()
            println("Principal: $principal")
            if (principal != null && principal.accessToken != null) {
                val tokenInfo = authService.processToken(principal.accessToken!!)
                call.respondText("Authentication successful! $tokenInfo")
            } else {
                call.respondText("Authentication failed!")
            }
        }
    }
}
