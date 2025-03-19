package com.example.navigation.screen

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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.navigation.viewmodel.MyViewmodel

@Composable
fun NextPageUI(modifier: Modifier = Modifier, navController: NavHostController, viewModel: MyViewmodel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "Next Page", color = Color.Black)
        Text(text = viewModel.textFieldValue.value, color = Color.Black)
        Button(
            onClick = {
                navController.navigate("page_3")
            },
            colors = ButtonDefaults.buttonColors(Color.Black)
        ) {
            Text(text = "Page 3", color = Color.White)
        }

    }

}