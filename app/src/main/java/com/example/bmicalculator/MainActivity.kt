package com.example.bmicalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateButton.setOnClickListener(){
            var height:Double = heightText.text.toString().toDouble()
            var weight:Double = weightText.text.toString().toDouble()
            var BMIResult:Double = weight / Math.pow(height, 2.0)

            BMIValueText.text = "BMI Value: %.2f".format(BMIResult)

            if(BMIResult < 18.5){
                imageView.setImageResource(R.drawable.under)
            }
            else if(BMIResult > 25.0){
                imageView.setImageResource(R.drawable.over)
            }
            else{
                imageView.setImageResource(R.drawable.normal)
            }
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }
        resetButton.setOnClickListener(){
            heightText.text = null
            weightText.text = null
            BMIValueText.text = null
            imageView.setImageResource(R.drawable.empty)
        }
    }
}
