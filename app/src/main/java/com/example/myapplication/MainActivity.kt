package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Références aux éléments de l'interface utilisateur
        val dice1Text: TextView = findViewById(R.id.dice1Text)
        val dice2Text: TextView = findViewById(R.id.dice2Text)
        val messageText: TextView = findViewById(R.id.messageText)
        val targetNumberInput: EditText = findViewById(R.id.targetNumberInput)
        val confettiView: ImageView = findViewById(R.id.confettiView)

        // Activer le lancement automatique lorsque l'utilisateur saisit un nombre
        targetNumberInput.addTextChangedListener { text ->
            val targetText = text.toString()
            if (targetText.isNotEmpty()) {
                val targetNumber = targetText.toIntOrNull()
                if (targetNumber != null && targetNumber in 2..12) {
                    // Lancer les dés
                    val dice1Roll = (1..6).random()
                    val dice2Roll = (1..6).random()

                    // Afficher les résultats
                    dice1Text.text = "Dé 1: $dice1Roll"
                    dice2Text.text = "Dé 2: $dice2Roll"

                    // Vérifier si la somme correspond au nombre cible
                    if (dice1Roll + dice2Roll == targetNumber) {
                        messageText.text = "Bravo ! Vous avez trouvé le bon nombre !"
                        messageText.setTextColor(resources.getColor(R.color.teal_700, theme))
                        showConfetti(confettiView)
                    } else {
                        messageText.text = "Dommage, réessayez. La somme était ${dice1Roll + dice2Roll}."
                        messageText.setTextColor(resources.getColor(R.color.black, theme))
                        confettiView.visibility = View.GONE
                    }
                } else {
                    messageText.text = "Entrez un nombre valide entre 2 et 12."
                    messageText.setTextColor(resources.getColor(R.color.red, theme))
                }
            }
        }
    }

    private fun showConfetti(confettiView: ImageView) {
        confettiView.visibility = View.VISIBLE

        // Animation de translation
        val animation = TranslateAnimation(0f, 0f, -1000f, 0f)
        animation.duration = 1000
        animation.fillAfter = true
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                confettiView.visibility = View.GONE
            }
            override fun onAnimationRepeat(animation: Animation) {}
        })
        confettiView.startAnimation(animation)
    }

}