package com.example.navigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigation.screen.screen2.HomeScreen
import com.example.navigation.screen.screen2.LoginScreen

@Composable
fun Nav2() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login"){
        composable(route = "login"){
            LoginScreen(navController = navController)
        }
        composable(
            route = "home/{name}/{password}",
            arguments = listOf(
                navArgument(name = "name"){
                    type = NavType.StringType
                },
                navArgument(name = "password") {
                    type = NavType.IntType
                }
            )
        ){backStackEntry ->
            HomeScreen(
                name = backStackEntry.arguments?.getString("name")?: "",
                password = backStackEntry.arguments?.getInt("password")?: 0
            )
        }
    }

}