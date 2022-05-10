package com.strv.movies.ui.loginscreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Movies app Login")
        var loginEmail by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = loginEmail,
            label = { Text(text = "Email") },
            onValueChange = { newText ->
                loginEmail = newText
            })
        var loginPassword by remember { mutableStateOf(TextFieldValue("")) }
        var passwordVisible by rememberSaveable { mutableStateOf(false) }
        OutlinedTextField(
            value = loginPassword,
            label = { Text(text = "Password") },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            onValueChange = { newText ->
                loginPassword = newText
            })
        Button(
            onClick = { }, modifier = Modifier
                .padding(8.dp)
                .size(width = 150.dp, height = 35.dp)
        ) {
            Text(text = "Login")
        }
        Button(
            onClick = { },
            modifier = Modifier
                .padding(8.dp)
                .size(width = 150.dp, height = 35.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Text(text = "Google")
        }
        Button(
            onClick = { }, modifier = Modifier
                .padding(8.dp)
                .size(width = 150.dp, height = 35.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFFF2400)
            )
        ) {
            Text(text = "Facebook")
        }
    }
}