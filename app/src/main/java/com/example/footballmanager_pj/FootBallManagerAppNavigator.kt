package com.example.footballmanager_pj

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.feature_join.presentation.screen.JoinScreen
import com.example.feature_join.presentation.screen.JoinSuccessScreen
import com.example.feature_join.presentation.screen.ProfileSettingScreen
import com.example.feature_join.presentation.viewmodel.JoinViewModel
import com.example.feature_login.presentation.screen.LoginScreen
import com.example.feature_makeclub.presentation.screen.CompleteClubMakingScreen
import com.example.feature_makeclub.presentation.screen.EmblemSelectScreen
import com.example.feature_makeclub.presentation.screen.MakeClubScreen
import com.example.feature_mypage.presentation.screen.MyPageModifyScreen
import com.example.feature_mypage.presentation.screen.MyPageScreen
import com.example.feature_mypage.presentation.viewmodel.MyPageViewModel
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
    val myPageViewModel: MyPageViewModel = hiltViewModel()
    val joinViewModel: JoinViewModel = hiltViewModel()
    NavHost(
        modifier = Modifier.padding(vertical = if (showBarList.contains(uiRoute.value)) 60.dp else 0.dp),
        navController = navHostController,
        startDestination = Route.JOIN
    ) {
        composable(Route.HOME) {
            onNavigate(Route.HOME)
            HomeScreen(navHostController)
        }
        composable(Route.LOGIN) {
            onNavigate(Route.LOGIN)
            LoginScreen(navHostController)
        }
        composable(Route.JOIN) {
            JoinScreen(
                navHostController, joinViewModel,
                onNavigateToProfileSettingScreen = {
                    navHostController.navigate("PROFILE_SETTING")
                },
            )
        }
        composable(Route.PROFILE_SETTING) {
            onNavigate(Route.PROFILE_SETTING)
            ProfileSettingScreen(
                joinViewModel,
                onNavigateToJoinSuccessScreen = { navHostController.navigate("JOIN_SUCCESS") })
        }
        composable(Route.JOIN_SUCCESS) {
            onNavigate(Route.JOIN_SUCCESS)
            JoinSuccessScreen()
        }
        composable(Route.SQUAD) {
            onNavigate(Route.SQUAD)
            SquadScreen()
        }
        composable(Route.SETTINGS) {
            onNavigate(Route.SETTINGS)
            MyPageScreen(
                navHostController,
                myPageViewModel,
                onNavigateToLogin = {
                    navHostController.navigate("LOGIN") {
                        popUpTo("SETTINGS") { inclusive = true }
                    }
                },
                onNavigateToMyPageModify = { navHostController.navigate("MYPAGE_MODIFY") }
            )
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
        composable(Route.MYPAGE_MODIFY) {
            MyPageModifyScreen(
                navHostController,
                myPageViewModel,
                onNavigateToMyPage = {
                    navHostController.navigate("SETTINGS") {
                        popUpTo("MYPAGE_MODIFY")
                    }
                })
        }
    }
}