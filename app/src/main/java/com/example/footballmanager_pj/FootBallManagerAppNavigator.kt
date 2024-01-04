package com.example.footballmanager_pj

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.feature_navigation.Route
import com.example.presentation.screen.HomeScreen

@Composable
fun FootBallManagerAppNavigator(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = Route.HOME) {
        composable(Route.HOME) {
            HomeScreen()
        }
        composable(Route.SCHEDULE) {
            Text(text = "SCHEDULE")
        }
        composable(Route.SETTINGS) {
            Text(text = "SETTINGS")
        }
    }
}