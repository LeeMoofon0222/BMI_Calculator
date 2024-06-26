package com.example.kotlin_project_0326

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val infoButton = findViewById<Button>(R.id.button3)
        infoButton.visibility = View.INVISIBLE;

        button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivityForResult(intent, 0)
        }

        infoButton.setOnClickListener {
            val intent = Intent(this, MainActivity6::class.java)
            startActivityForResult(intent, 0)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK) { // Check for RESULT_OK
            val infoButton = findViewById<Button>(R.id.button3)
            infoButton.visibility = View.VISIBLE;
            val name = data?.getBundleExtra("key")?.getString("Name")
            val height = data?.getBundleExtra("key")?.getString("Height")?.toDoubleOrNull()
            val weight = data?.getBundleExtra("key")?.getString("Weight")?.toDoubleOrNull()
            val gender = data?.getBundleExtra("key")?.getString("Gender")
            val bmi = 10000* weight?.div((height!! *height))!!
            var status = ""
            if (bmi != null) {
                if(bmi<18.5){
                    status = "Underweight"
                }
                else if(18.5<=bmi&&bmi<24){
                    status = "Normal"
                }
                else if(24<=bmi&&bmi<27){
                    status = "Overweight"
                }
                else if(27<=bmi&&bmi<30){
                    status = "Mild Obesity"
                }
                else if(30<=bmi&&bmi<35){
                    status = "Moderate Obesity"
                }
                else{
                    status = "Severe Obesity"
                }
            }
            findViewById<TextView>(R.id.textView7).text = "Name: $name"
            findViewById<TextView>(R.id.textView4).text = "Genda: $gender"
            findViewById<TextView>(R.id.textView5).text = "BMI Value: ${String.format("%.1f", bmi)}"
            findViewById<TextView>(R.id.textView6).text = "Status: $status"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("NameText", findViewById<TextView>(R.id.textView7).text.toString())
        outState.putString("GenderText", findViewById<TextView>(R.id.textView4).text.toString())
        outState.putString("BMIText", findViewById<TextView>(R.id.textView5).text.toString())
        outState.putString("StatusText", findViewById<TextView>(R.id.textView6).text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        findViewById<TextView>(R.id.textView7).text = savedInstanceState.getString("NameText")
        findViewById<TextView>(R.id.textView4).text = savedInstanceState.getString("GenderText")
        findViewById<TextView>(R.id.textView5).text = savedInstanceState.getString("BMIText")
        findViewById<TextView>(R.id.textView6).text = savedInstanceState.getString("StatusText")
    }

}
