package com.example.navigation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MyViewmodel: ViewModel() {
    private val _textFieldValue = mutableStateOf("")
    val textFieldValue = _textFieldValue

    fun updateTextFieldValue(value: String) {
        _textFieldValue.value = value
    }
}