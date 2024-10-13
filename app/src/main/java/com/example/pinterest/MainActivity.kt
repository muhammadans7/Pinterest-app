package com.example.pinterest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import com.example.pinterest.ui.theme.PinterestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PinterestTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                    var isLoggedIn by remember { mutableStateOf(false) }
                    var loginMessage by remember { mutableStateOf("") }
                    var username by remember { mutableStateOf("") }
                    if (isLoggedIn) {
                        ProfileScreen(
                            username = username,
                            onEditProfileClick = {

                                isLoggedIn = false
                                loginMessage = ""
                            }
                        )
                    } else {
                        LoginScreen(
                            onLoginSuccess = { success ->
                                isLoggedIn = success
                                if (success) {
                                    username = "Jon snow"
                                    loginMessage = "Login successful!"
                                } else {
                                    loginMessage = "Login failed"
                                }
                            },
                            loginMessage = loginMessage
                        )
                    }
                }
            }
        }
    }
}
