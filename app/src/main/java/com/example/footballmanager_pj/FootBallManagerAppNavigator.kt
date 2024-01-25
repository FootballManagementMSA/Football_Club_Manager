package com.example.footballmanager_pj

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.feature_makeclub.presentation.screen.CompleteClubMakingScreen
import com.example.feature_makeclub.presentation.screen.EmblemSelectScreen
import com.example.feature_makeclub.presentation.screen.MakeClubScreen
import com.example.feature_mypage.presentation.screen.MyPageModifyScreen
import com.example.feature_mypage.presentation.screen.MyPageScreen
import com.example.feature_navigation.Route
import com.example.feature_navigation.showBarList
import com.example.feature_squard.presentation.screen.SquadScreen
import com.example.presentation.screen.HomeScreen

@Composable
fun FootBallManagerAppNavigator(
    navHostController: NavHostController,
    uiRoute: State<String>,
    onNavigate: (String) -> Unit
) {
    NavHost(
        modifier = Modifier.padding(vertical = if (showBarList.contains(uiRoute.value)) 60.dp else 0.dp),
        navController = navHostController,
        startDestination = Route.HOME
    ) {
        composable(Route.HOME) {
            onNavigate(Route.HOME)
            HomeScreen(navHostController)
        }
        composable(Route.SQUAD) {
            onNavigate(Route.SQUAD)
            SquadScreen()
        }
        composable(Route.SETTINGS) {
            onNavigate(Route.SETTINGS)
            Text(text = "Settings")
        }
        composable(Route.MAKE_CLUB) {
            onNavigate(Route.MAKE_CLUB)
            MakeClubScreen()
        }
        composable(Route.EMBLEM_SELECT) {
            onNavigate(Route.EMBLEM_SELECT)
            EmblemSelectScreen()
        }
        composable(Route.COMPLETE_CLUB_MAKING) {
            onNavigate(Route.COMPLETE_CLUB_MAKING)
            CompleteClubMakingScreen()
        }
        composable(Route.MYPAGE) {
            MyPageScreen()
        }
        composable(Route.MYPAGE_MODIFY) {
            MyPageModifyScreen()
        }
    }
}