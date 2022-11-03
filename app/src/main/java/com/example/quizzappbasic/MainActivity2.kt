package com.example.quizzappbasic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity() {
    lateinit var checkBox: CheckBox

//    lateinit var spinner : Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val spinner = findViewById<Spinner>(R.id.spinner1)

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

        val chk = findViewById<CheckBox>(R.id.checkbox1)
        val chk2 = findViewById<CheckBox>(R.id.checkbox2)
        val chk3 = findViewById<CheckBox>(R.id.checkbox3)
        val chk4 = findViewById<CheckBox>(R.id.checkbox4)
        val chk5 = findViewById<CheckBox>(R.id.checkbox5)
//        val btnVer = findViewById<Button>(R.id.btnVer)
        val ExSeekBar = findViewById<SeekBar>(R.id.ExSeekBar)
        val txtSeek = findViewById<TextView>(R.id.txtSeek)

        val btnRegresar = findViewById<Button>(R.id.btnRegresar)
        btnRegresar.setOnClickListener()
        {

            val lanzar = Intent(this, MainActivity::class.java)
            lanzar.putExtra("DIFICULTAD",spinner.selectedItem.toString())
            startActivity(lanzar)
        }

        //slider para escoger la cantidad de preguntas

        ExSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                txtSeek.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })


    }




}

