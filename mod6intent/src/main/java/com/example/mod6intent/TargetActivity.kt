package com.example.mod6intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TargetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_target)
        val prenom = intent.getStringExtra("prenom")
    }
}