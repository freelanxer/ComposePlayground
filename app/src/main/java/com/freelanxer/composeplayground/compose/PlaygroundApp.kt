package com.freelanxer.composeplayground.compose

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.freelanxer.composeplayground.compose.messagecard.MessageCardScreen
import com.freelanxer.composeplayground.compose.settings.SettingsScreen

@Composable
fun PlaygroundApp() {
    val navController = rememberNavController()
    PlaygroundNavHost(
        navController = navController
    )
}

@Composable
fun PlaygroundNavHost(
    navController: NavHostController
) {
    val activity = LocalContext.current as Activity
    NavHost(
        navController = navController,
        startDestination = Screen.MessageCard.route
    ) {
        composable(route = Screen.MessageCard.route) {
            MessageCardScreen {
                navController.navigate(Screen.Settings.route)
            }
        }
        composable(route = Screen.Settings.route) {
            SettingsScreen {
                navController.navigateUp()
            }
        }
    }
}