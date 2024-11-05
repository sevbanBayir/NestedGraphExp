package com.sevban.nestedgraphexp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import kotlinx.serialization.Serializable

sealed interface Destination {

    sealed interface HomeDestination : Destination {
        @Serializable
        data object HomeGraph : HomeDestination

        @Serializable
        data object Home1 : HomeDestination

        @Serializable
        data object Home2 : HomeDestination

        @Serializable
        data object Home3 : HomeDestination
    }

    sealed interface ProfileDestination : Destination {
        @Serializable
        data object ProfileGraph : ProfileDestination

        @Serializable
        data object Profile1 : ProfileDestination

        @Serializable
        data object Profile2 : ProfileDestination

        @Serializable
        data object Profile3 : ProfileDestination
    }

    sealed interface MenuDestination : Destination {
        @Serializable
        data object MenuGraph : MenuDestination

        @Serializable
        data object Menu1 : MenuDestination

        @Serializable
        data object Menu2 : MenuDestination

        @Serializable
        data object Menu3 : MenuDestination
    }
}

enum class TopLevelDestination(val route: Destination, val icon: ImageVector) {
    HOME(Destination.HomeDestination.HomeGraph, icon = Icons.Default.Home),
    PROFILE(Destination.ProfileDestination.ProfileGraph, icon = Icons.Default.Person),
    MENU(Destination.MenuDestination.MenuGraph, icon = Icons.Default.Menu)
}

fun NavController.navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
    navigate(topLevelDestination.route) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}