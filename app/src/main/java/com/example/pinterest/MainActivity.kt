//package com.example.pinterest
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.Modifier
//import com.example.pinterest.ui.theme.PinterestTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            PinterestTheme {
//                Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
//                    var isLoggedIn by remember { mutableStateOf(false) }
//                    var loginMessage by remember { mutableStateOf("") }
//                    var username by remember { mutableStateOf("") }
//                    if (isLoggedIn) {
//                        ProfileScreen(
//                            username = username,
//                            onEditProfileClick = {
//
//                                isLoggedIn = false
//                                loginMessage = ""
//                            }
//                        )
//                    } else {
//                        LoginScreen(
//                            onLoginSuccess = { success ->
//                                isLoggedIn = success
//                                if (success) {
//                                    username = "Jon snow"
//                                    loginMessage = "Login successful!"
//                                } else {
//                                    loginMessage = "Login failed"
//                                }
//                            },
//                            loginMessage = loginMessage
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
package com.example.pinterest

import android.content.Intent
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
import Home.HomeScreen // Import your HomeScreen

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
                        // Start HomeScreen activity when the user is logged in
                        val intent = Intent(this@MainActivity, HomeScreen::class.java)
                        intent.putExtra("USERNAME", username) // Optionally pass the username
                        startActivity(intent)
                        finish() // Optional: Close MainActivity
                    } else {
                        LoginScreen(
                            onLoginSuccess = { success ->
                                isLoggedIn = success
                                if (success) {
                                    username = "Jon Snow" // Example username
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

