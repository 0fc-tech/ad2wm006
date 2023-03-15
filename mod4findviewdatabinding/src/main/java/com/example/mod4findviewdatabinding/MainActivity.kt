package com.example.mod4findviewdatabinding

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.mod4findviewdatabinding.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var amb : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Affiche l'interface graphique layout activity_main.xml
        amb = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val nasique = Singe("Nasique", "Jean-Michel",25,"Marron-Orange")
        amb.singe = nasique
        //val textView = findViewById<TextView>(R.id.textView)
        //val button = findViewById<Button>(R.id.button)
        amb.textViewHelloWorld.text = "HELLO WORLD 😊😊😊😂😂😂🤣🤣"
        amb.button.setBackgroundColor(Color.GREEN)

        amb.button.setOnClickListener {
            Snackbar.make(it,
                "Hello vous avez push un bouton :D :D :D",
                1000).show()
        }

    }
}




