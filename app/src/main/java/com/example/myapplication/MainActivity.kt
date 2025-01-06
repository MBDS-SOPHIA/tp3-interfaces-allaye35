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
        val targetNumberInput: EditText = findViewById(R.id.targetNumberInput)

        // Désactiver le bouton au démarrage
        rollButton.isEnabled = false

        // Activer le bouton uniquement si un nombre est saisi
        targetNumberInput.addTextChangedListener { text ->
            rollButton.isEnabled = !text.isNullOrEmpty()
        }

        // Actions lorsque le bouton est cliqué
        rollButton.setOnClickListener {
            // Vérifier si une valeur valide est entrée
            val targetText = targetNumberInput.text.toString()
            if (targetText.isEmpty()) {
                Toast.makeText(this, "Veuillez entrer un nombre cible.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val targetNumber = targetText.toIntOrNull()
            if (targetNumber == null || targetNumber < 2 || targetNumber > 12) {
                Toast.makeText(this, "Entrez un nombre valide entre 2 et 12.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Générer deux nombres aléatoires entre 1 et 6
            val dice1Roll = (1..6).random()
            val dice2Roll = (1..6).random()

            // Afficher les résultats des dés dans les TextView
            dice1Text.text = "Dé 1: $dice1Roll"
            dice2Text.text = "Dé 2: $dice2Roll"

            // Vérifier si la somme des dés est égale au nombre cible
            if (dice1Roll + dice2Roll == targetNumber) {
                messageText.text = "Bravo ! Vous avez trouvé le bon nombre !"
                messageText.setTextColor(resources.getColor(R.color.teal_700, theme))
            } else {
                messageText.text = "Dommage, réessayez. La somme était ${dice1Roll + dice2Roll}."
                messageText.setTextColor(resources.getColor(R.color.black, theme))
            }
        }
    }
}