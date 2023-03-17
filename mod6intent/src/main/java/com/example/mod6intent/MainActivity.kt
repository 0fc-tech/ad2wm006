package com.example.mod6intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()){ isGranted ->
        val intent = Intent(
            if(isGranted) Intent.ACTION_CALL else Intent.ACTION_VIEW,
            Uri.parse("tel:+1(202)-418-5000"))
        startActivity(intent)
    }
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
        findViewById<Button>(R.id.buttonCallCIA).setOnClickListener {
            //INTENT IMPLICITE = VIEW GEO
            requestPermissionLauncher.launch(android.Manifest.permission.CALL_PHONE)
        }
    }
}