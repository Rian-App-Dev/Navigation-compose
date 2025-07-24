package com.example.navigation.navigation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HomeUi(text: String, onValueChange:(x: String) -> Unit, navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = text,
            onValueChange = {onValueChange(it)},
            label = { Text(text = "Enter your Name") }
        )
        Spacer(modifier = Modifier.height(70.dp))
        Button(
            onClick = {
                navController.navigate("nextPage")
            },
            colors = ButtonDefaults.buttonColors(Color.Black)
        ) {
            Text(text = "Submit", color = Color.White)

        }
    }

}