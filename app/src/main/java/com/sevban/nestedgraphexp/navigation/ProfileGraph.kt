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
import com.sevban.nestedgraphexp.navigation.Destination.ProfileDestination

fun NavGraphBuilder.profileGraph(navController: NavController) {
    navigation<ProfileDestination.ProfileGraph>(startDestination = ProfileDestination.Profile1) {
        composable<ProfileDestination.Profile1> {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(ProfileDestination.Profile1.toString())
                Button(onClick = { navController.navigate(ProfileDestination.Profile2) }) {
                    Text("Next")
                }
            }
        }

        composable<ProfileDestination.Profile2> {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(ProfileDestination.Profile2.toString())
                Button(onClick = { navController.navigate(ProfileDestination.Profile3) }) {
                    Text("Next")
                }
            }
        }

        composable<ProfileDestination.Profile3> {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(ProfileDestination.Profile3.toString())
                /*Button(onClick = { navController.navigate(HomeDestination.Home3) }) {
                    Text("Next")
                }*/
            }
        }
    }
}