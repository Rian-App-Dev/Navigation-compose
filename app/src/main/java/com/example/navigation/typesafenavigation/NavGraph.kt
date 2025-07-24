package com.example.navigation.typesafenavigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.navigation.typesafenavigation.screens.HomeScreen
import com.example.navigation.typesafenavigation.screens.RegisterScreen

@Composable
fun Nav3(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Dest.RegisterScreen){
        composable<Dest.RegisterScreen> {
            RegisterScreen { name, email, password, imageUri->
                navController.navigate(Dest.HomeScreen(name = name, email = email, password = password, imageUri = imageUri))
            }
        }
        composable<Dest.HomeScreen> {
            val name = it.toRoute<Dest.HomeScreen>().name
            val email = it.toRoute<Dest.HomeScreen>().email
            val password = it.toRoute<Dest.HomeScreen>().password
            val imageUri = it.toRoute<Dest.HomeScreen>().imageUri
            HomeScreen(name = name, email = email, password = password, imageUri = imageUri)
        }
    }
}

sealed interface Dest{
    @Serializable
    data object RegisterScreen

    @Serializable
    data class HomeScreen(
        val name: String,
        val email: String,
        val password: String,
        val imageUri: String
    )
}