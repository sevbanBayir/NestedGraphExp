package com.sevban.nestedgraphexp.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sevban.nestedgraphexp.navigation.Destination.MenuDestination

fun NavGraphBuilder.menuGraph(navController: NavController) {
    navigation<MenuDestination.MenuGraph>(startDestination = MenuDestination.Menu1) {
        composable<MenuDestination.Menu1> {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(MenuDestination.Menu1.toString())
                Button(onClick = { navController.navigate(MenuDestination.Menu2) }) {
                    Text("Next")
                }
            }
        }

        composable<MenuDestination.Menu2> {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(MenuDestination.Menu2.toString())
                Button(onClick = { navController.navigate(MenuDestination.Menu3) }) {
                    Text("Next")
                }
            }
        }

        composable<MenuDestination.Menu3> {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(MenuDestination.Menu3.toString())
                /*Button(onClick = { navController.navigate(HomeDestination.Home3) }) {
                    Text("Next")
                }*/
            }
        }
    }
}