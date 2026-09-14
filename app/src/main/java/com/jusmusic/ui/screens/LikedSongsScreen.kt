package com.jusmusic.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jusmusic.ui.theme.JUSTheme
import com.jusmusic.ui.theme.JUSType
import com.jusmusic.ui.theme.JUSColors

@Composable
fun LikedSongsScreen() {
    JUSTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 48.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Liked Songs",
                style = JUSType.displayLarge,
                color = JUSColors.onBackground
            )
            Spacer(modifier = Modifier.height(32.dp))
            val songs = listOf(
                "Midnight Rain",
                "Solar Pulse",
                "Neon Drift",
                "Echoes in White",
                "Aurora Waves",
                "Static Bloom"
            )
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(songs) { title ->
                    Text(
                        text = title,
                        style = JUSType.bodyLarge,
                        color = JUSColors.onBackground
                    )
                }
            }
        }
    }
}
