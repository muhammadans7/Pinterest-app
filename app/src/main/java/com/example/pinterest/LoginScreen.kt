package com.example.pinterest
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier

@Composable
fun LoginScreen(onLoginSuccess: (Boolean) -> Unit, loginMessage: String) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showSignUp by remember { mutableStateOf(false) }
    var loginAttempted by remember { mutableStateOf(false) }
//    display Sign Up screen
    if (showSignUp) {
        SignUpScreen(onSignUpSuccess = { showSignUp = false })
    } else {
        Scaffold(
            containerColor = Color.White,
            content = { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Login", style = MaterialTheme.typography.headlineMedium)

                    Spacer(modifier = Modifier.height(24.dp))

                    // Username field
                    TextField(
                        value = username,
                        onValueChange = { username = it },
                        label = { Text("Username") },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color(0xFFE1F5FE),
                            unfocusedContainerColor = Color(0xFFF1F8E9)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color(0xFFE1F5FE),
                            unfocusedContainerColor = Color(0xFFF1F8E9)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Login button
                    Button(
                        onClick = {
                            loginAttempted = true
                            if (username.isNotBlank() && password.isNotBlank()) {
                                onLoginSuccess(true)
                            } else {
                                onLoginSuccess(false)
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Login")
                    }

                    if (loginAttempted) {
                        if (loginMessage.isNotEmpty()) { // Display the login message if it's not empty
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(text = loginMessage, color = MaterialTheme.colorScheme.primary)
                        } else {

                            Text(text = "Please enter valid credentials.", color = MaterialTheme.colorScheme.error)
                        }
                    }

                    // Sign Up button
                    TextButton(
                        onClick = { showSignUp = true },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Don't have an account? Sign Up")
                    }
                }
            }
        )
    }
}
