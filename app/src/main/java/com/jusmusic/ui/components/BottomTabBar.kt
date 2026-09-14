package com.jusmusic.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.jusmusic.ui.theme.JUSColors

@Composable
fun BottomTabBar(
    selectedTab: Int = 0,
    onTabSelected: (Int) -> Unit = {}
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = JUSColors.background
    ) {
        val tabs = listOf(
            Pair("Home", Icons.Filled.Home),
            Pair("Search", Icons.Filled.Search),
            Pair("Library", Icons.Filled.LibraryMusic),
            Pair("Liked", Icons.Filled.Favorite)
        )
        tabs.forEachIndexed { index, (label, icon) ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = label,
                        tint = if (selectedTab == index) Color(0xFF0A0A0A) else JUSColors.inactive
                    )
                },
                selected = selectedTab == index,
                onClick = { onTabSelected(index) },
                label = { },
                alwaysShowLabel = false
            )
        }
    }
}
