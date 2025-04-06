package com.example.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.navigation.navigation.Nav
import com.example.navigation.navigation.Nav2
import com.example.navigation.ui.theme.NavigationTheme
import com.example.navigation.viewmodel.MyViewmodel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MyViewmodel by viewModels()
        // val viewModel = viewModels<MyViewmodel>()
        enableEdgeToEdge()
        setContent {
            NavigationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Nav(viewModel = viewModel)
                }
            }
        }
    }
}


