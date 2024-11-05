package com.sevban.nestedgraphexp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sevban.nestedgraphexp.navigation.Destination
import com.sevban.nestedgraphexp.navigation.TopLevelDestination
import com.sevban.nestedgraphexp.navigation.homeGraph
import com.sevban.nestedgraphexp.navigation.menuGraph
import com.sevban.nestedgraphexp.navigation.navigateToTopLevelDestination
import com.sevban.nestedgraphexp.navigation.profileGraph
import com.sevban.nestedgraphexp.ui.theme.NestedGraphExpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NestedGraphExpTheme {
                val navController = rememberNavController()
                val currentDestination = navController.currentBackStackEntryAsState().value?.destination
                Scaffold(
                    bottomBar = {
                        NavigationBar {
                            TopLevelDestination.entries.forEach { topLevelDestination ->
                                val selected = currentDestination?.parent?.hasRoute(topLevelDestination.route::class) == true
                                NavigationBarItem(
                                    selected = selected,
                                    onClick = { navController.navigateToTopLevelDestination(topLevelDestination) },
                                    icon = {
                                        Icon(
                                            imageVector = topLevelDestination.icon,
                                            contentDescription = null
                                        )
                                    }
                                )
                            }
                        }
                    }
                ) { padding ->
                    NavHost(
                        navController = navController,
                        startDestination = Destination.HomeDestination.HomeGraph,
                        modifier = Modifier.padding(padding)
                    ) {
                        homeGraph(navController)
                        profileGraph(navController)
                        menuGraph(navController)
                    }
                }
            }
        }
    }
}