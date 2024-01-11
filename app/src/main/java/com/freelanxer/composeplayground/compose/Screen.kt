package com.freelanxer.composeplayground.compose

sealed class Screen(
    val route: String
) {
    data object MessageCard: Screen(
        route = "messageCard"
    )

    data object Settings: Screen(
        route = "settings"
    )
}