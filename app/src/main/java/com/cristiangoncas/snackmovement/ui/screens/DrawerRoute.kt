package com.cristiangoncas.snackmovement.ui.screens

import kotlinx.serialization.Serializable

@Serializable
sealed class DrawerRoute(val name: String, val route: String) {

    @Serializable
    data object Goals : DrawerRoute("Goals", "Goals")

    @Serializable
    data object Profile : DrawerRoute("Profile", "Profile")

    @Serializable
    data object Settings : DrawerRoute("Settings", "Settings")
}