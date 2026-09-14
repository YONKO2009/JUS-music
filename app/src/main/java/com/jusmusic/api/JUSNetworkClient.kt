package com.jusmusic.api

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object JUSNetworkClient {

    val baseUrl = "https://www.youtube.com/youtubei/v1/"

    val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = false
            })
        }
        install(WebSockets)
    }

    suspend fun get(path: String, headers: Map<String, String> = defaultHeaders()): HttpResponse {
        return client.get("$baseUrl$path") {
            headers.forEach { (k, v) -> header(k, v) }
        }
    }

    suspend fun post(path: String, body: String? = null, headers: Map<String, String> = defaultHeaders()): HttpResponse {
        return client.post("$baseUrl$path") {
            headers.forEach { (k, v) -> header(k, v) }
            if (body != null) {
                setBody(body)
            }
        }
    }

    private fun defaultHeaders(): Map<String, String> = mapOf(
        "Accept" to "application/json",
        "Content-Type" to "application/json",
        "User-Agent" to "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"
    )
}
