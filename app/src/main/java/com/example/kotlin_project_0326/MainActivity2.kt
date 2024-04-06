package com.example.kotlin_project_0326

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            val bundle = Bundle()
            val name = findViewById<EditText>(R.id.editTextText).text.toString()
            val height = findViewById<EditText>(R.id.editTextText2).text.toString()
            val weight = findViewById<EditText>(R.id.editTextText3).text.toString()
            val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
            val radioButton = findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
            val gender = radioButton.text.toString()
            bundle.putString("Name",name)
            bundle.putString("Height",height)
            bundle.putString("Weight",weight)
            bundle.putString("Gender",gender)
            val intent = Intent()
            intent.putExtra("key",bundle)
            setResult(RESULT_OK,intent)
            finish()
        }
    }

}