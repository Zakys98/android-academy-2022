package com.strv.movies.ui.loginscreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.strv.movies.ui.theme.md_theme_light_primary

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoginText()
            LoginEmail()
            LoginPassword()
            LoginButton(text = "Sign in", color = MaterialTheme.colors.primary)

        }

        Row(
            modifier = Modifier
                .weight(1f, false)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "or sign in with")
                LoginButton("Google", Color.White)
                LoginButton("Facebook", Color(0xFF009CFF))
            }
        }
    }
}

@Composable
fun LoginText() {
    Text(text = "Movies app Login", fontSize = 30.sp, fontStyle = FontStyle.Italic)
}

@Composable
fun LoginEmail() {
    var loginEmail by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = loginEmail,
        label = { Text(text = "Email") },
        onValueChange = { newText ->
            loginEmail = newText
        })
}

@Composable
fun LoginPassword() {
    var loginPassword by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    OutlinedTextField(
        value = loginPassword,
        label = { Text(text = "Password") },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        onValueChange = { newText ->
            loginPassword = newText
        })
}

@Composable
fun LoginButton(text: String, color: Color) {
    Button(
        onClick = { }, modifier = Modifier
            .padding(8.dp)
            .size(width = 150.dp, height = 35.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color
        )
    ) {
        Text(text = text)
    }
}
