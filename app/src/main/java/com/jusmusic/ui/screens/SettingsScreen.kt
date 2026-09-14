package com.jusmusic.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jusmusic.ui.theme.JUSTheme
import com.jusmusic.ui.theme.JUSType
import com.jusmusic.ui.theme.JUSColors

@Composable
fun SettingsScreen() {
    JUSTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 48.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Step 1: Profile Section
            Box(
                modifier = Modifier
                    .size(96.dp)
                    .clip(CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    shape = CircleShape,
                    color = JUSColors.secondary,
                    contentColor = JUSColors.background
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        // Placeholder profile circle
                    }
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Alex Rivera",
                style = JUSType.headlineLarge,
                color = JUSColors.onBackground
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Premium Plan",
                style = JUSType.bodyLarge,
                color = JUSColors.secondary
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Step 2: Settings List Items
            val settings = listOf(
                "Upgrade Plan",
                "Download Music",
                "Audio Quality",
                "Privacy Settings",
                "Notifications"
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                settings.forEach { item ->
                    Text(
                        text = item,
                        style = JUSType.bodyLarge,
                        color = JUSColors.onBackground,
                        modifier = Modifier.padding(vertical = 12.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // Step 3: Log Out Button
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(top = 16.dp),
                shape = MaterialTheme.shapes.extraLarge,
                colors = ButtonDefaults.buttonColors(
                    containerColor = JUSColors.onBackground,
                    contentColor = JUSColors.background
                )
            ) {
                Text(
                    text = "Log Out",
                    style = JUSType.bodyLarge,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
