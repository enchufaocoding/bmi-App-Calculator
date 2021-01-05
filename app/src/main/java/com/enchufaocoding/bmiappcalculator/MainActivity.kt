package com.enchufaocoding.bmiappcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var calculateButton : Button
    private lateinit var weightEditText : EditText
    private lateinit var heightEditText : EditText
    private lateinit var bmiTextView : TextView
    private lateinit var bmiImageView : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateButton = findViewById(R.id.calculate_button)
        weightEditText = findViewById(R.id.weight_edit_text)
        heightEditText = findViewById(R.id.height_edit_text)
        bmiTextView = findViewById(R.id.bmi_text_view)
        bmiImageView = findViewById(R.id.bmi_image_view)

        calculateButton.setOnClickListener {
          canCalculateBMI()
        }

    }

    private fun calculateBMI(){

        val height = heightEditText.text.toString().toFloat()
        val weight = weightEditText.text.toString().toFloat()
        val myBMI = weight / (height*height)

        bmiTextView.text = myBMI.toString()

        when {
            myBMI < 18.5 -> {
                bmiImageView.setImageResource(R.drawable.underweight)
            }
            myBMI >= 18.5 && myBMI < 24.9 -> {
                bmiImageView.setImageResource(R.drawable.healthy)
            }
            myBMI >= 24.9 && myBMI < 29.9 -> {
                bmiImageView.setImageResource(R.drawable.overweight)
            }
            myBMI >= 29.9 -> {
                bmiImageView.setImageResource(R.drawable.obesity)
            }
        }
    }

    private fun canCalculateBMI() {
            if (weightEditText.text.isNotEmpty() && heightEditText.text.isNotEmpty()) {
                calculateBMI()
            } else {
                Toast.makeText(this, "Enter the Needed Fields", Toast.LENGTH_SHORT).show()
            }
    }

}