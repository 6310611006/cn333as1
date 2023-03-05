package com.example.numberguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var guessEditText: EditText
    private lateinit var guessButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var newGameButton: Button

    private var randomNumber: Int = 0
    private var numGuesses: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        guessEditText = findViewById(R.id.guessEditText)
        guessButton = findViewById(R.id.guessButton)
        resultTextView = findViewById(R.id.resultTextView)
        newGameButton = findViewById(R.id.newGameButton)

        newGameButton.setOnClickListener {
            startNewGame()
        }

        startNewGame()

        guessButton.setOnClickListener {
            val guess = guessEditText.text.toString().toIntOrNull()

            if (guess != null) {
                numGuesses++

                if (guess == randomNumber) {
                    resultTextView.text = "Correct! You guessed the number in $numGuesses guesses."
                    newGameButton.visibility = Button.VISIBLE
                } else if (guess < randomNumber) {
                    resultTextView.text = "Too low! Guess higher."
                } else {
                    resultTextView.text = "Too high! Guess lower."
                }
            } else {
                resultTextView.text = "Please enter a valid number."
            }

            guessEditText.text.clear()
        }
    }

    private fun startNewGame() {
        numGuesses = 0
        randomNumber = Random.nextInt(1, 101)
        resultTextView.text = ""
        newGameButton.visibility = Button.GONE
    }
}
