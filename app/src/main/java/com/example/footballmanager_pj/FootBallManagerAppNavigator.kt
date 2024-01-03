package com.example.footballmanager_pj

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.presentation.screen.HomeScreen

@Composable
fun FootBallManagerAppNavigator(
    navHostController: NavHostController = rememberNavController()
) {
    NavHost(navController = navHostController, startDestination = "HOME"){
        composable("HOME"){
            HomeScreen(navHostController = navHostController)
        }
    }
}