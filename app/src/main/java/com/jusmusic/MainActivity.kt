package com.jusmusic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import android.content.Context
import com.jusmusic.player.JUSPlayerController
import com.jusmusic.navigation.JUSNavHost
import com.jusmusic.ui.components.BottomTabBar
import com.jusmusic.ui.components.MiniPlayer
import com.jusmusic.ui.theme.JUSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val controller = JUSPlayerController(this)
        setContent {
            JUSTheme {
                MainShell(controller)
            }
        }
    }
}

@Composable
fun MainShell(controller: JUSPlayerController) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomTabBar() },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            JUSNavHost(
                navController = navController,
                controller = controller,
                modifier = Modifier.fillMaxSize()
            )
            Column(modifier = Modifier.fillMaxSize()) {
                Box(modifier = Modifier.weight(1f))
                MiniPlayer()
            }
        }
    }
}
