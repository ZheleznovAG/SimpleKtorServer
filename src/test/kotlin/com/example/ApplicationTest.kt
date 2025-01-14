package com.example

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.server.testing.*
import io.ktor.http.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ApplicationTest {

    @Test
    fun `test root endpoint`() = testApplication {
        application {
            module()
        }

        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }
}
