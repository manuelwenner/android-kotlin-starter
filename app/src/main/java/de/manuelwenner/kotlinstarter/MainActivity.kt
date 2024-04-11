package de.manuelwenner.kotlinstarter

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnSubmit).setOnClickListener{
            findViewById<TextView>(R.id.tvContent).text = "Yaaay it worked"
            findViewById<ImageView>(R.id.ivBatman).animate().scaleX(1.0F).duration = 2000
        }
    }
}