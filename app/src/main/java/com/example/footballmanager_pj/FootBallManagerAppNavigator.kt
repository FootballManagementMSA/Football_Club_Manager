package com.example.footballmanager_pj

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.feature_makeclub.presentation.screen.CompleteClubMakingScreen
import com.example.feature_makeclub.presentation.screen.EmblemSelectScreen
import com.example.feature_makeclub.presentation.screen.MakeClubScreen
import com.example.feature_navigation.Route
import com.example.presentation.screen.HomeScreen

@Composable
fun FootBallManagerAppNavigator(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = Route.HOME) {
        composable(Route.HOME) {
            HomeScreen(navHostController)
        }
        composable(Route.SCHEDULE) {
            Text(text = "SCHEDULE")
        }
        composable(Route.SETTINGS) {
            Text(text = "SETTINGS")
        }
        composable(Route.MAKE_CLUB) {
            MakeClubScreen()
        }
        composable(Route.EMBLEM_SELECT) {
            EmblemSelectScreen()
        }
        composable(Route.COMPLETE_CLUB_MAKING) {
            CompleteClubMakingScreen()
        }
    }
}