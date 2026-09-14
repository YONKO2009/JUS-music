package com.jusmusic.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jusmusic.player.JUSPlayerController
import com.jusmusic.api.models.Track
import com.jusmusic.ui.theme.JUSTheme
import com.jusmusic.ui.theme.JUSType
import com.jusmusic.ui.theme.JUSColors

@Composable
fun QueueScreen(controller: JUSPlayerController) {
    val queue by controller.queue.collectAsStateWithLifecycle()
    JUSTheme {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                itemsIndexed(queue) { index, track ->
                    Box(modifier = Modifier.fillMaxSize().padding(8.dp)) {
                        Text(
                            text = "${track.title} - ${track.artist}",
                            style = JUSType.bodyMedium,
                            color = JUSColors.onBackground
                        )
                        Button(
                            onClick = { controller.removeAt(index) },
                            modifier = Modifier.align(Alignment.CenterEnd)
                        ) {
                            Text("Remove")
                        }
                    }
                }
            }
        }
    }
}
