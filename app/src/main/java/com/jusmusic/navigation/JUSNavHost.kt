package com.jusmusic.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun JUSNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {
        composable("home") { HomePlaceholder() }
        composable("search") { SearchPlaceholder() }
        composable("library") { LibraryPlaceholder() }
        composable("liked") { LikedPlaceholder() }
        composable("player") { PlayerPlaceholder() }
        composable("album") { AlbumPlaceholder() }
        composable("artist") { ArtistPlaceholder() }
        composable("playlist") { PlaylistPlaceholder() }
    }
}

@Composable
fun HomePlaceholder() {
    androidx.compose.material3.Text("Home Screen")
}

@Composable
fun SearchPlaceholder() {
    androidx.compose.material3.Text("Search Screen")
}

@Composable
fun LibraryPlaceholder() {
    androidx.compose.material3.Text("Library Screen")
}

@Composable
fun LikedPlaceholder() {
    androidx.compose.material3.Text("Liked Screen")
}

@Composable
fun PlayerPlaceholder() {
    androidx.compose.material3.Text("Player Screen")
}

@Composable
fun AlbumPlaceholder() {
    androidx.compose.material3.Text("Album Screen")
}

@Composable
fun ArtistPlaceholder() {
    androidx.compose.material3.Text("Artist Screen")
}

@Composable
fun PlaylistPlaceholder() {
    androidx.compose.material3.Text("Playlist Screen")
}
