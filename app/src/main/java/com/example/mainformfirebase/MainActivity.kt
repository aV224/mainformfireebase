package com.example.mainformfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.io.Serializable

class MainActivity : AppCompatActivity() {  // I modified AndroidManifest.xml to make this the starting activity instead of MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val heightinput : EditText = findViewById<EditText>(R.id.height)
        val ageinput : EditText = findViewById<EditText>(R.id.age)
        val weightinput : EditText = findViewById<EditText>(R.id.weight)
        val genderinput : EditText = findViewById<EditText>(R.id.gender)
        val raceinput : EditText = findViewById<EditText>(R.id.race)
        val nextButton : Button = findViewById<Button>(R.id.next_button)    // the button

        nextButton.setOnClickListener {  // when button is clicked
            val intent : Intent = Intent(this@MainActivity, SubmittedActivity::class.java)  // class to go to next activity

            val height = heightinput.text.toString()   // retrieving user input
            val age = ageinput.text.toString()
            val weight = weightinput.text.toString()
            val gender = genderinput.text.toString()
            val race = raceinput.text.toString()

            intent.putExtra("Height Info", height)   // sending the info to the next activity
            intent.putExtra("Age Info", age)
            intent.putExtra("Weight Info", weight)
            intent.putExtra("Gender Info", gender)
            intent.putExtra("Race Info", race)

            startActivity(intent)    // go to next activity
        }

        /*heightinput.setOnClickListener {   // when the user clicks on it to type, the existing text will automatically vanish with this code. It is aided by focusableInTouchMode in the xml file.
            heightinput.setText("")
            heightinput.isFocusableInTouchMode = true   // in the xml file, I made this false because it allowed me to wipe the existing text with only one click instead of two... however, it wouldn't let me type so I made it true again
        }

        ageinput.setOnClickListener {
            ageinput.setText("")
            ageinput.isFocusableInTouchMode = true
        }

        weightinput.setOnClickListener {
            weightinput.setText("")
            weightinput.isFocusableInTouchMode = true
        }

        genderinput.setOnClickListener {
            genderinput.setText("")
            genderinput.isFocusableInTouchMode = true
        }

        raceinput.setOnClickListener {
            raceinput.setText("")
            raceinput.isFocusableInTouchMode = true
        } */
    }
}