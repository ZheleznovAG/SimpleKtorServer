package com.example

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.server.testing.*
import io.ktor.http.*
import kotlin.test.Test
import kotlin.test.assertEquals

class RoutingTest {

    @Test
    fun testHelloEndpoint() = testApplication {
        application {
            configureFrameworks()
            configureRouting()
        }

        client.get("/hello").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello from HelloService!", bodyAsText())
        }
    }
}
