package com.freelanxer.composeplayground.model

data class SettingsGroup(
    val category: String,
    val settingsList: ArrayList<String> = arrayListOf(
        "Brightness",
        "Font size",
        "Display size",
        "Dark mode"
    ),
)
