package com.example.mod6intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener {
            //INTENT EXPLICITE
            val intent = Intent(this,TargetActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.buttonGeo).setOnClickListener {
            //INTENT IMPLICITE = VIEW GEO
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("geo:47.228589,-1.6178463"))
            startActivity(intent)
        }
    }
}