package com.example.mainformfirebase

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SubmittedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submitted)
        supportActionBar?.hide()

        val height = intent.getStringExtra("Height Info")   // retrieving all patient info from the previous activity
        val age = intent.getStringExtra("Age Info")
        val weight = intent.getStringExtra("Weight Info")
        val gender = intent.getStringExtra("Gender Info")
        val race = intent.getStringExtra("Race Info")

        val heightText = findViewById<TextView>(R.id.heightcheck)   // defining textview objects
        val ageText = findViewById<TextView>(R.id.agecheck)
        val weightText = findViewById<TextView>(R.id.weightcheck)
        val genderText = findViewById<TextView>(R.id.gendercheck)
        val raceText = findViewById<TextView>(R.id.racecheck)

        heightText.text = height    // outputting the text so the user can check their information
        ageText.text = age
        weightText.text = weight
        genderText.text = gender
        raceText.text = race

        val sendButton = findViewById<Button>(R.id.send_button)
        sendButton.setOnClickListener {   // firebase activity starts here
            val patientInfo = hashMapOf<String, Any?>(    // the patient's info stored in a hashmap
                "Height" to height,
                "Age" to age,
                "Weight" to weight,
                "Gender" to gender,
                "Race" to race
            )

            val  db = Firebase.firestore

            db.collection("users")
                .add(patientInfo)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
        }
    }
}