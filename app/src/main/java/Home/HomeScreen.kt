//package Home
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.GridLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.pinterest.R
//
//class HomeScreen : AppCompatActivity() {
//
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var pinAdapter: PinAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home) // Ensure this layout file exists and is correct
//
//        // Initialize RecyclerView
//        recyclerView = findViewById(R.id.recyclerView)
//
//        // Set the layout manager to GridLayoutManager with 2 columns
//        recyclerView.layoutManager = GridLayoutManager(this, 2)
//
//        // Sample data for testing (ensure R.drawable.sample_image_1 exists)
//        val pinList = listOf(
//            Pin("Ronaldo 🔥", R.drawable.r), // Replace with your actual drawable names
//            Pin("Messi 🔥", R.drawable.mm),
//            Pin("Bellingham 🔥", R.drawable.bellingham),
//            Pin("Neymar Jr 🔥", R.drawable.ne),
//            Pin("Nature", R.drawable.sample_image_1),
//            Pin("Ronaldo Wallpapers", R.drawable.rr),
//            Pin("Real Madrid", R.drawable.madrid),
//            Pin("cars wallpapers", R.drawable.cars),
//            Pin("Nature", R.drawable.audi),
//            Pin("🔥", R.drawable.quotes),
//            Pin("Nissan", R.drawable.ni), // Replace with your actual drawable names
//
//            // Add more pins as needed
//        )
//
//        // Set up the adapter
//        pinAdapter = PinAdapter(pinList)
//        recyclerView.adapter = pinAdapter
//    }
//}

//package Home
//
//import android.content.Intent
//import android.os.Bundle
//import android.widget.ImageView
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.GridLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.pinterest.ProfileActivity // Import your ProfileActivity
//import com.example.pinterest.R
//
//class HomeScreen : AppCompatActivity() {
//
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var pinAdapter: PinAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home) // Ensure this layout file exists and is correct
//
//        // Initialize RecyclerView
//        recyclerView = findViewById(R.id.recyclerView)
//
//        // Set the layout manager to GridLayoutManager with 2 columns
//        recyclerView.layoutManager = GridLayoutManager(this, 2)
//
//        // Sample data for testing
//        val pinList = listOf(
//            Pin("Ronaldo 🔥", R.drawable.r),
//            Pin("Messi 🔥", R.drawable.mm),
//            Pin("Bellingham 🔥", R.drawable.bellingham),
//            Pin("Neymar Jr 🔥", R.drawable.ne),
//            Pin("Nature", R.drawable.sample_image_1),
//            Pin("Ronaldo Wallpapers", R.drawable.rr),
//            Pin("Real Madrid", R.drawable.madrid),
//            Pin("cars wallpapers", R.drawable.cars),
//            Pin("Nature", R.drawable.audi),
//            Pin("🔥", R.drawable.quotes),
//            Pin("Nissan", R.drawable.ni), // Replace with your actual drawable names
//            // ... Add more pins as needed
//        )
//
//        // Set up the adapter
//        pinAdapter = PinAdapter(pinList)
//        recyclerView.adapter = pinAdapter
//
//        // Set up the profile icon click listener
//        val profileIcon = findViewById<ImageView>(R.id.icon_profile) // Ensure you have this in your layout
//        profileIcon.setOnClickListener {
//            // Start ProfileActivity when the profile icon is clicked
//            val intent = Intent(this, ProfileActivity::class.java)
//            startActivity(intent)
//        }
//    }
//}


package Home

import android.content.Intent
import android.os.Bundle
import android.widget.Button // Import Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pinterest.ProfileActivity
import com.example.pinterest.R

class HomeScreen : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var pinAdapter: PinAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        // Sample data for testing
        val pinList = listOf(
            Pin("Ronaldo 🔥", R.drawable.r),
            Pin("Messi 🔥", R.drawable.mm),
            Pin("Bellingham 🔥", R.drawable.bellingham),
            Pin("Neymar Jr 🔥", R.drawable.ne),
            Pin("Nature", R.drawable.sample_image_1),
            Pin("Ronaldo Wallpapers", R.drawable.rr),
            Pin("Real Madrid", R.drawable.madrid),
            Pin("cars wallpapers", R.drawable.cars),
            Pin("Nature", R.drawable.audi),
            Pin("🔥", R.drawable.quotes),
            Pin("Nissan", R.drawable.ni)
        )

        // Set up the adapter
        pinAdapter = PinAdapter(pinList)
        recyclerView.adapter = pinAdapter

        // Set up the profile icon click listener
        val profileIcon = findViewById<ImageView>(R.id.icon_profile)
        profileIcon.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        // Set up the comment button click listener
        val commentButton = findViewById<ImageView>(R.id.icon_comment)
        commentButton.setOnClickListener {
            // Start CommentActivity when the comment button is clicked
            val intent = Intent(this, CommentActivity::class.java)
            startActivity(intent)
        }
    }
}
