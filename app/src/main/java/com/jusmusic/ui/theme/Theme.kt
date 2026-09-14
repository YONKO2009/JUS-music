package com.jusmusic.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

val JUSType = Typography(
    displayLarge = TextStyle(fontFamily = GasoekOne, fontSize = 34.sp, letterSpacing = (-0.8).sp),
    displayMedium = TextStyle(fontFamily = GasoekOne, fontSize = 28.sp, letterSpacing = (-0.7).sp),
    headlineLarge = TextStyle(fontFamily = DelaGothicOne, fontSize = 30.sp, letterSpacing = (-0.7).sp),
    titleLarge = TextStyle(fontFamily = Figtree, fontSize = 20.sp, letterSpacing = (-0.3).sp),
    bodyLarge = TextStyle(fontFamily = Figtree, fontSize = 16.sp),
    bodyMedium = TextStyle(fontFamily = Figtree, fontSize = 14.sp),
    labelMedium = TextStyle(fontFamily = Figtree, fontSize = 12.sp),
)

@Composable
fun JUSTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        typography = JUSType,
        content = content
    )
}
