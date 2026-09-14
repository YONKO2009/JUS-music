package com.jusmusic.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val GasoekOne = FontFamily(Font(R.font.gasoek_one, FontWeight.Normal))
val DelaGothicOne = FontFamily(Font(R.font.dela_gothic_one, FontWeight.Normal))
val Figtree = FontFamily(
    Font(R.font.figtree, FontWeight.Normal),
    Font(R.font.figtree, FontWeight.Medium)
)

val JUSType = Typography(
    displayLarge = TextStyle(
        fontFamily = GasoekOne,
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    // ... (rest of type styles)
    headlineLarge = TextStyle(
        fontFamily = DelaGothicOne,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Figtree,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Figtree,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)

