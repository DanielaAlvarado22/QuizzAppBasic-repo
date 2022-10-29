package com.example.quizzappbasic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity() {
    lateinit var checkBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

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

