package com.jusmusic.api

import com.jusmusic.api.models.BrowseResponse
import com.jusmusic.api.models.PlayerResponse
import com.jusmusic.api.models.SearchResponse
import io.ktor.client.call.body

class JUSApiEndpoints(private val client: JUSNetworkClient = JUSNetworkClient) {

    suspend fun search(query: String): SearchResponse {
        val body = """{"context":{"client":{"clientName":"WEB","clientVersion":"2.20230728.00.00"}},"query":"$query"}"""
        val response = client.post("search?key=API_KEY&prettyPrint=false", body = body)
        return response.body()
    }

    suspend fun browse(browseId: String): BrowseResponse {
        val body = """{"context":{"client":{"clientName":"WEB","clientVersion":"2.20230728.00.00"}},"browseId":"$browseId"}"""
        val response = client.post("browse?key=API_KEY&prettyPrint=false", body = body)
        return response.body()
    }

    suspend fun getPlaybackDetails(videoId: String): PlayerResponse {
        val body = """{"context":{"client":{"clientName":"WEB","clientVersion":"2.20230728.00.00"}},"videoId":"$videoId","playbackContext":{"contentPlaybackContext":{"html5Preference":"HTML5_PREF_WANTS"}}}"""
        val response = client.post("player?key=API_KEY&prettyPrint=false", body = body)
        return response.body()
    }
}
