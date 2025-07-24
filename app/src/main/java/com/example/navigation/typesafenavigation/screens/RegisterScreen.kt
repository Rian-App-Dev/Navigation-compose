package com.example.navigation.typesafenavigation.screens

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import com.example.navigation.R

@Composable
fun RegisterScreen(modifier: Modifier = Modifier, onClick: (name: String, email: String, password: String, imageUri: String) -> Unit) {
    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }
    val imageUri = remember { mutableStateOf<Uri?>("android.resource://com.example.registerwithnavigation/${R.drawable.img}".toUri()) }
    Log.d("TAG", imageUri.value.toString())
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = {
            imageUri.value = it ?: imageUri.value
        }
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
//        Image(painter = rememberAsyncImagePainter(imageUri.value),
//            contentDescription = null,
//            modifier = Modifier
//                .size(200.dp)
//                .clip(RoundedCornerShape(20.dp))
//                .clickable {
//                    launcher.launch("image/*")
//                }
//        )
        AsyncImage(
            model = imageUri.value,
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .clip(
                    shape = RoundedCornerShape(20.dp)
                )
                .clickable {
                    launcher.launch("image/*")
                })
        Spacer(
            modifier = Modifier.size(20.dp)
        )
        TextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text(text = "Name") }
        )
        TextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text(text = "Email") }
        )
        TextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text(text = "Password") }
        )
        TextField(
            value = confirmPassword.value,
            onValueChange = { confirmPassword.value = it },
            label = { Text(text = "Confirm Password") }
        )
        Spacer(
            modifier = Modifier.size(20.dp)
        )
        Button(
            onClick = {
                onClick(name.value, email.value, password.value, imageUri.value.toString())
            },
            colors = ButtonDefaults.buttonColors(Color.Black)
        ) {
            Text(text = "Register", color = Color.White)
        }


    }
}
