package com.example.mainformfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper


class LoadingScreen : AppCompatActivity() {    // I modified AndroidManifest.xml to make this the starting activity instead of MainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading_screen)

        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({    // just a cool splash screen... I added a picture of the vytal logo but we can change it
            val intent : Intent = Intent(this@LoadingScreen, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 1500)     // 1.5 secs of the splash screen and then mainactivity opens up
    }
}