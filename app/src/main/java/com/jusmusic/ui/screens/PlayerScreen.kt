package com.jusmusic.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jusmusic.player.JUSPlayerController
import com.jusmusic.ui.theme.JUSTheme
import com.jusmusic.ui.theme.JUSType
import com.jusmusic.ui.theme.JUSColors

@Composable
fun PlayerScreen(controller: JUSPlayerController) {
    val isPlaying by controller.isPlaying.collectAsStateWithLifecycle()
    val currentTrack by controller.currentTrack.collectAsStateWithLifecycle()
    val playbackProgress by controller.playbackProgress.collectAsStateWithLifecycle()

    JUSTheme {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = currentTrack ?: "No track loaded",
                    style = JUSType.displayMedium,
                    color = JUSColors.onBackground,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 16.dp)
                ) {
                    Button(
                        onClick = { controller.play() },
                        enabled = !isPlaying
                    ) {
                        Text("Play")
                    }
                    Spacer(modifier = Modifier.size(16.dp))
                    Button(
                        onClick = { controller.pause() },
                        enabled = isPlaying
                    ) {
                        Text("Pause")
                    }
                }

                LinearProgressIndicator(
                    progress = { if (playbackProgress > 0) 0.5f else 0f },
                    modifier = Modifier.fillMaxWidth().height(8.dp),
                    color = JUSColors.primary,
                    trackColor = JUSColors.inactive
                )

                Text(
                    text = "Progress: $playbackProgress ms",
                    style = JUSType.bodyMedium,
                    color = JUSColors.onBackground,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}
