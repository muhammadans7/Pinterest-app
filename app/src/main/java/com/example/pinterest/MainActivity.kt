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
                    var loginMessage by remember { mutableStateOf("") } //hold the login message
                    var username by remember { mutableStateOf("") } //hold the username

                    // Display the message
                    if (isLoggedIn) {
                        ProfileScreen(username = username)
                    } else {
                        LoginScreen(
                            onLoginSuccess = { success ->
                                isLoggedIn = success
                                if (success) {
                                    username = "jonsnow"
                                    loginMessage = "Login Successful!"
                                } else {
                                    loginMessage = ""
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
