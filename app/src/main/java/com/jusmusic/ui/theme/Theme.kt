package com.jusmusic.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = NearBlack,
    onPrimary = White,
    secondary = GraySecondary,
    onSecondary = White,
    background = White,
    onBackground = NearBlack,
    surface = White,
    onSurface = NearBlack,
)

@Composable
fun JUSTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColorScheme(
            primary = NearBlack,
            onPrimary = White,
            secondary = GraySecondary,
            onSecondary = White,
            background = NearBlack,
            onBackground = White,
            surface = NearBlack,
            onSurface = White,
        ) else LightColorScheme,
        typography = JUSType,
        content = content
    )
}
