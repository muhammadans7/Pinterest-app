package com.example.pinterest

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity


class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content to your ProfileScreen Composable
        setContent {
            ProfileScreen(username = "YourUsername", onEditProfileClick = {
                // Handle edit profile click, if needed
            })
        }
    }
}
