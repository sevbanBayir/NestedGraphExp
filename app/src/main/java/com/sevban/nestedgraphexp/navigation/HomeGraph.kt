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
import com.sevban.nestedgraphexp.navigation.Destination.HomeDestination

fun NavGraphBuilder.homeGraph(navController: NavController) {
    navigation<HomeDestination.HomeGraph>(startDestination = HomeDestination.Home1) {
        composable<HomeDestination.Home1> {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(HomeDestination.Home1.toString())
                Button(onClick = { navController.navigate(HomeDestination.Home2) }) {
                    Text("Next")
                }
            }
        }

        composable<HomeDestination.Home2> {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(HomeDestination.Home2.toString())
                Button(onClick = { navController.navigate(HomeDestination.Home3) }) {
                    Text("Next")
                }
            }
        }

        composable<HomeDestination.Home3> {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(HomeDestination.Home3.toString())
                /*Button(onClick = { navController.navigate(HomeDestination.Home3) }) {
                    Text("Next")
                }*/
            }
        }
    }
}