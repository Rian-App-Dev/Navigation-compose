package com.example.navigation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


import androidx.navigation.compose.rememberNavController
import com.example.navigation.screen.HomeUi
import com.example.navigation.screen.NextPageUI
import com.example.navigation.screen.Page_3Ui
import com.example.navigation.viewmodel.MyViewmodel

@Composable
fun Nav(modifier: Modifier = Modifier, viewModel: MyViewmodel) {
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

    }
}