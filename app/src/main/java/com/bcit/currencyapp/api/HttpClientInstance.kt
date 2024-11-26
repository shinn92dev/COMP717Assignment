package com.bcit.currencyapp.api

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.gson.*

object HttpClientInstance {
    val client = HttpClient(Android) {
        install(ContentNegotiation) {
            gson()
        }
    }
}
