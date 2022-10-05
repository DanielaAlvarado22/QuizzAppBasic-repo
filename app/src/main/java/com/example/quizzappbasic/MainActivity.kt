package com.example.quizzappbasic

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    val dificultad = arrayOf("Facil","Normal","Dificil")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnOpciones = findViewById<Button>(R.id.btnOpciones)
        btnOpciones.setOnClickListener {
            val lanzar = Intent(this,MainActivity2::class.java)
            startActivity(lanzar)
        }

        val btnJugar = findViewById<Button>(R.id.btnJugar)
        btnJugar.setOnClickListener {
            val lanzar = Intent(this,MainActivity3::class.java)
            startActivity(lanzar)
        }

        val spinner = findViewById<Spinner>(R.id.spinner1)
        val arrayAdapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,dificultad)
        spinner.adapter = arrayAdapter



//       --- placeholder del spinner---
//        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onItemSelected(
//                p0: AdapterView<*>?,
//                p1: View?,
//                position: Int,
//                p3: Long) {
//
//            }
//
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//                TODO("Not yet implemented")
//            }
//
//        }
    }
}