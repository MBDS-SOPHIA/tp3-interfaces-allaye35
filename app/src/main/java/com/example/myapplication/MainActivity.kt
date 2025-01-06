package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Références au bouton et au texte
        val rollButton: Button = findViewById(R.id.rollButton)
        val resultText: TextView = findViewById(R.id.resultText)

        // Action lorsque le bouton est cliqué
        rollButton.setOnClickListener {
            val diceRoll = (1..6).random() // Nombre aléatoire entre 1 et 6
            resultText.text = diceRoll.toString() // Mise à jour du texte
        }
    }
}