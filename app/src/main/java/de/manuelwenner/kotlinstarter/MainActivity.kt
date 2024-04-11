package de.manuelwenner.kotlinstarter

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRandomText = findViewById<Button>(R.id.btnRandomText);
        val btnLoadScreen = findViewById<Button>(R.id.btnLoadScreen);

        btnRandomText.setOnClickListener {
            findViewById<TextView>(R.id.tvContent).text = "I'm Batman"
            findViewById<ImageView>(R.id.ivBatman).animate().scaleX(1.0f).setDuration(2000)
        }

        btnLoadScreen.setOnClickListener {
            val explicitIntent = Intent(this, ListActivity::class.java)
            startActivity(explicitIntent)
        }
    }
}