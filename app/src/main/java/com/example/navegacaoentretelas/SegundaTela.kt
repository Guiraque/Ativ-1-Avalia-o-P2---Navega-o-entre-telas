package com.example.navegacaoentretelas

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity

class SegundaTela : AppCompatActivity() {

    private lateinit var redButton: Button
    private lateinit var greenButton: Button
    private lateinit var blueButton: Button
    private lateinit var randomColorButton: Button
    private lateinit var layout: RelativeLayout
    private lateinit var nextButton: Button
    private lateinit var backButton: Button
    private lateinit var resetButton: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_tela)
        setTitle("Tela 2")

        redButton = findViewById(R.id.redButton)
        greenButton = findViewById(R.id.greenButton)
        blueButton = findViewById(R.id.blueButton)
        randomColorButton = findViewById(R.id.randomColorButton)
        layout = findViewById(R.id.layout)
        nextButton = findViewById(R.id.nextButton)
        backButton = findViewById(R.id.backButton)
        resetButton = findViewById(R.id.resetButton)

        // Usar preferências separadas para a SegundaTela
        sharedPreferences = getSharedPreferences("SegundaTelaPrefs", Context.MODE_PRIVATE)

        val backgroundColor = sharedPreferences.getInt("backgroundColor", android.R.color.white)
        layout.setBackgroundColor(backgroundColor)

        redButton.setOnClickListener {
            val color = getColor(R.color.red)
            layout.setBackgroundColor(color)
            saveBackgroundColor(color)
        }

        greenButton.setOnClickListener {
            val color = getColor(R.color.green)
            layout.setBackgroundColor(color)
            saveBackgroundColor(color)
        }

        blueButton.setOnClickListener {
            val color = getColor(R.color.blue)
            layout.setBackgroundColor(color)
            saveBackgroundColor(color)
        }

        randomColorButton.setOnClickListener {
            val colors = intArrayOf(R.color.red, R.color.green, R.color.blue)
            val randomColor = getColor(colors.random())
            layout.setBackgroundColor(randomColor)
            saveBackgroundColor(randomColor)
        }

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        resetButton.setOnClickListener {
            val defaultColor = getColor(android.R.color.white)
            layout.setBackgroundColor(defaultColor)
            saveBackgroundColor(defaultColor)
        }

        nextButton.setOnClickListener {
            val intent = Intent(this, TerceiraTela::class.java)
            startActivity(intent)
        }
    }

    private fun saveBackgroundColor(color: Int) {
        sharedPreferences.edit().putInt("backgroundColor", color).apply()
    }
}
