package com.jusmusic.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Pause
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jusmusic.ui.theme.JUSColors
import com.jusmusic.ui.theme.JUSType

@Composable
fun MiniPlayer() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(JUSColors.background)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = "Song Title",
            style = JUSType.bodyLarge,
            color = Color(0xFF0A0A0A),
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.PlayArrow,
                    contentDescription = "Play",
                    tint = Color(0xFF0A0A0A)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.Pause,
                    contentDescription = "Pause",
                    tint = Color(0xFF0A0A0A)
                )
            }
        }
        LinearProgressIndicator(
            progress = { 0.3f },
            modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
            color = Color(0xFF0A0A0A),
            trackColor = JUSColors.inactive
        )
    }
}
