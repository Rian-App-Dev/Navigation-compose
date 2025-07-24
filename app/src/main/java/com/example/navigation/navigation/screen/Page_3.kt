package com.example.navigation.navigation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.navigation.viewmodel.MyViewmodel

@Composable
fun Page_3Ui(navController: NavHostController, viewModel: MyViewmodel) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Page 3", color = Color.Black)
        Button(
            onClick = {
                navController.navigate("home"){
                    popUpTo("home"){
                        inclusive = true
                    }
                }
                viewModel.updateTextFieldValue("")
            },
            colors = ButtonDefaults.buttonColors(Color.Black)
        ) {
            Text(text = "Home", color = Color.White)
        }
        Button(
            onClick = {
                navController.navigate("login")
            },
            colors = ButtonDefaults.buttonColors(Color.Black)
        ) {
            Text(text = "Login", color = Color.White)
        }
    }
}