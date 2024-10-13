package com.example.pinterest
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.LazyColumn

@Composable
fun ProfileScreen(username: String) {
    Scaffold(
        containerColor = Color.White,
        content = { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                item {
                    Text(text = "Profile", style = MaterialTheme.typography.headlineMedium)

                    Spacer(modifier = Modifier.height(24.dp))

                    // Profile Information
                    Text(text = "Username: $username", style = MaterialTheme.typography.bodyLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Email: youknownothing@gmail.com", style = MaterialTheme.typography.bodyLarge) // Placeholder for email
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Bio : Crafting stories through visuals, one pin at a time", style = MaterialTheme.typography.bodyLarge)
                    Spacer(modifier = Modifier.height(24.dp))

                    Text(text = "Jon Snow Pins", style = MaterialTheme.typography.headlineSmall)
                    Spacer(modifier = Modifier.height(16.dp))
                }


                for (i in 1..8) { // Displaying the all pins
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F8E9))
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Text(text = "Pin Item #$i", style = MaterialTheme.typography.bodyLarge)
                                Text(text = "\"A curated collection of ideas and inspirations, where creativity meets endless possibilities. Dive into a world of design, art, and imagination.\"\n" +
                                        "\n ", style = MaterialTheme.typography.bodySmall)
                            }
                        }
                    }
                }
            }
        }
    )
}
