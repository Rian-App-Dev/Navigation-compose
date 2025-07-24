package com.example.navigation.navigationwithargument.screen2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun LoginScreen(navController: NavHostController) {
    val name = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(placeholder = {
            Text(text = "Enter your name")
        },value = name.value, onValueChange = {name.value = it})
        TextField(placeholder = {
            Text(text = "Enter your password")
        },value = password.value, onValueChange = {password.value = it})
        Button(
            colors = ButtonDefaults.buttonColors(Color.Black),
            enabled = name.value.isNotEmpty() && password.value.isNotEmpty(),
            onClick = {
                navController.navigate("lastpage/${name.value}/${password.value}")
            }
        ) {
            Text(text = "Login", color = Color.White)
        }
    }
}

