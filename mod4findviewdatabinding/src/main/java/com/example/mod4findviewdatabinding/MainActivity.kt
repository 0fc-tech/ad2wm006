package com.example.mod4findviewdatabinding

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Affiche l'interface graphique layout activity_main.xml
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)
        textView.text = "HELLO WORLD 😊😊😊😂😂😂🤣🤣"
        button.setBackgroundColor(Color.GREEN)
        button.setOnClickListener {
            Snackbar.make(it,
                "Hello vous avez push un bouton :D :D :D",
                1000).show()
        }

    }
}




