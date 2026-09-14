package com.jusmusic.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jusmusic.player.JUSPlayerController
import com.jusmusic.ui.screens.HomeScreen
import com.jusmusic.ui.screens.SearchScreen
import com.jusmusic.ui.screens.PlayerScreen
import com.jusmusic.ui.screens.LibraryScreen
import com.jusmusic.ui.screens.LikedSongsScreen
import com.jusmusic.ui.screens.QueueScreen
import com.jusmusic.ui.screens.SettingsScreen
import com.jusmusic.ui.screens.LoginScreen

@Composable
fun JUSNavHost(
    navController: NavHostController,
    controller: JUSPlayerController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {
        composable("home") { HomeScreen() }
        composable("search") { SearchScreen() }
        composable("library") { LibraryScreen() }
        composable("liked") { LikedSongsScreen() }
        composable("player") { PlayerScreen(controller = controller) }
        composable("queue") { QueueScreen(controller = controller) }
        composable("settings") { SettingsScreen() }
        composable("login") { LoginScreen() }
    }
}
