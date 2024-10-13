package com.example.pinterest
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier

@Composable
fun SignUpScreen(onSignUpSuccess: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var signUpSuccessful by remember { mutableStateOf(false) }

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
                Text(text = "Sign Up", style = MaterialTheme.typography.headlineMedium)

                Spacer(modifier = Modifier.height(24.dp))

                // Username input field
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

                // Password input field
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

                Spacer(modifier = Modifier.height(16.dp))

                // Confirm Password input field
                TextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    label = { Text("Confirm Password") },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFE1F5FE),
                        unfocusedContainerColor = Color(0xFFF1F8E9)
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Sign Up button
                Button(
                    onClick = {
                        if (username.isNotBlank() && password.isNotBlank() && password == confirmPassword) {
                            signUpSuccessful = true
                            onSignUpSuccess() // Navigate back to Login screen on success
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Sign Up")
                }

                // Feedback message
                if (signUpSuccessful) {
                    Text(text = "Sign Up Successful", color = MaterialTheme.colorScheme.primary)
                }
            }
        }
    )
}
