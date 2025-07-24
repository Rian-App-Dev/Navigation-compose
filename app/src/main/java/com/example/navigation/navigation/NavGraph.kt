package com.example.navigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigation.navigation.screen.HomeUi
import com.example.navigation.navigation.screen.NextPageUI
import com.example.navigation.navigation.screen.Page_3Ui
import com.example.navigation.navigationwithargument.screen2.HomeScreen
import com.example.navigation.navigationwithargument.screen2.LoginScreen
import com.example.navigation.viewmodel.MyViewmodel

@Composable
fun Nav(viewModel: MyViewmodel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home"){
        composable(route = "home"){
            HomeUi(navController = navController, text = viewModel.textFieldValue.value, onValueChange = {viewModel.updateTextFieldValue(it)})
        }
        composable(route = "nextPage"){
            NextPageUI(navController = navController, viewModel = viewModel)
        }
        composable(route = "page_3"){
            Page_3Ui(navController = navController, viewModel = viewModel)
        }
        composable(route = "login"){
            LoginScreen(navController = navController)
        }
        composable(
            route = "lastpage/{name}/{password}",
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