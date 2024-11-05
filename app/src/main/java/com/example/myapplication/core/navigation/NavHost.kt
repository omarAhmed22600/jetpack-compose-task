package com.example.myapplication.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.ui.profileScreen.ProfileScreen
import com.example.myapplication.ui.connectScreen.ConnectScreen
import com.example.myapplication.ui.homeScreen.HomeScreen
import com.example.myapplication.ui.questionsScreen.QuestionsScreen
import com.example.myapplication.ui.toolsScreen.ToolsScreen

object Screens {
    const val HOME_SCREEN_NAV = "Home Screen"
    const val CONNECTOR_SCREEN_NAV = "Connector Screen"
    const val QUESTIONS_SCREEN_NAV = "Questions Screen"
    const val TOOLS_SCREEN_NAV = "Tools Screen"
    const val PROFILE_SCREEN_NAV = "Profile Screen"
}

@Composable
fun MainNavHost(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screens.HOME_SCREEN_NAV) {
        composable(Screens.HOME_SCREEN_NAV) {
            HomeScreen(navController)
        }
        composable(Screens.CONNECTOR_SCREEN_NAV) {
            ConnectScreen(navController = navController)
        }
        composable(Screens.QUESTIONS_SCREEN_NAV) {
            QuestionsScreen(navController = navController)
        }
        composable(Screens.TOOLS_SCREEN_NAV) {
            ToolsScreen(navController = navController)
        }
        composable(Screens.PROFILE_SCREEN_NAV) {
            ProfileScreen(navController = navController)
        }

    }

}