package com.example.quizzappbasic

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var dificultad : MutableList<String>
    lateinit var spinner : Spinner
    lateinit var dif: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById<Spinner>(R.id.spinner1)

        ArrayAdapter.createFromResource(
            this,
            R.array.Dificultad,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }


        val btnOpciones = findViewById<Button>(R.id.btnOpciones)
        btnOpciones.setOnClickListener {
            val lanzar = Intent(this, MainActivity2::class.java)
            startActivity(lanzar)
        }

        val btnJugar = findViewById<Button>(R.id.btnJugar)
        btnJugar.setOnClickListener {

            val lanzar = Intent(this, MainActivity3::class.java)
            lanzar.putExtra("DIFICULTAD",spinner.selectedItem.toString())
            startActivity(lanzar)
        }







    }
}