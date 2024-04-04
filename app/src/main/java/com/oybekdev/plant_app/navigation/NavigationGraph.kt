package com.oybekdev.plant_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oybekdev.plant_app.presentation.loginScreen.SignInScreen
import com.oybekdev.plant_app.presentation.signUpScreen.SignUpScreen

@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Screens.SignInScreen.route
    ) {
        composable(route = Screens.SignInScreen.route) {
            SignInScreen()
        }
        composable(route = Screens.SignUpScreen.route) {
            SignUpScreen()
        }
    }

}