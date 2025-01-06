package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        // Références aux éléments de l'interface utilisateur
        val dice1Text: TextView = findViewById(R.id.dice1Text)
        val dice2Text: TextView = findViewById(R.id.dice2Text)
        val messageText: TextView = findViewById(R.id.messageText)
        val rollButton: Button = findViewById(R.id.rollButton)

        // Actions lorsque le bouton est cliqué
        rollButton.setOnClickListener {
            // Générer deux nombres aléatoires entre 1 et 6
            val dice1Roll = (1..6).random()
            val dice2Roll = (1..6).random()

            // Afficher les résultats des dés dans les TextView
            dice1Text.text = "Dé 1: $dice1Roll"
            dice2Text.text = "Dé 2: $dice2Roll"

            // Vérifier si les deux dés affichent le même numéro
            if (dice1Roll == dice2Roll) {
                messageText.text = "Félicitations ! Vous avez obtenu un double : $dice1Roll"
                messageText.setTextColor(resources.getColor(R.color.teal_700, theme)) // Couleur de succès
            } else {
                messageText.text = "Pas de double cette fois, essayez encore !"
                messageText.setTextColor(resources.getColor(R.color.black, theme)) // Couleur d'échec
            }
        }
    }
}