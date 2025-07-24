package com.example.navigation.typesafenavigation.screens

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.Uri
import coil3.compose.AsyncImage

@Composable
fun HomeScreen(modifier: Modifier = Modifier, name: String, email: String, password: String, imageUri: String) {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color =Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            model = imageUri,
            contentDescription = null,
            modifier = Modifier.size(200.dp)
                .clip(
                    shape = RoundedCornerShape(20.dp)
                )
        )
        Spacer(
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = "Name: $name",
            color = Color.White
        )
        Text(
            text = "Email: $email",
            color = Color.White
        )
        Text(
            text = "Password: $password",
            color = Color.White
        )
        Text(
            text = "Confirm password: $password",
            color = Color.White
        )
    }
}