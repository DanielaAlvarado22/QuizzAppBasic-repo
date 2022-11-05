package com.example.quizzappbasic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.room.Room
import com.example.quizzappbasic.daos.GameDataBase

class MainActivity2 : AppCompatActivity() {

    lateinit var btnGuardarConfig : Button
    lateinit var chk1 : CheckBox
    lateinit var chk2: CheckBox
    lateinit var chk3: CheckBox
    lateinit var chk4: CheckBox
    lateinit var chk5: CheckBox
    lateinit var chk6: CheckBox
    lateinit var ExSeekBar:SeekBar
    lateinit var txtSeek:TextView
    lateinit var btnRegresar : Button
    lateinit var spinner : Spinner
    lateinit var switchPistas: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //region Variables Botones,Checkbox,Spinner
        spinner = findViewById(R.id.spinner1)
        btnGuardarConfig = findViewById(R.id.btnGuardarConfig)
        chk1 = findViewById(R.id.checkbox1)
        chk2 = findViewById(R.id.checkbox2)
        chk3 = findViewById(R.id.checkbox3)
        chk4 = findViewById(R.id.checkbox4)
        chk5 = findViewById(R.id.checkbox5)
        chk6 = findViewById(R.id.checkbox6)
        ExSeekBar = findViewById(R.id.ExSeekBar)
        txtSeek = findViewById(R.id.txtSeek)
        btnRegresar = findViewById(R.id.btnRegresar)
        switchPistas = findViewById(R.id.switchPistas)

        //endregion

        //region BASE DE DATOS
        val db = Room.databaseBuilder(
            applicationContext,
            GameDataBase::class.java, "quizapp")
            .allowMainThreadQueries()
            .build()

        val configDao =db.configDao()

        //endregion

        //region SPINNER

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

        //endregion

        //region SLIDER

        ExSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                txtSeek.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        //endregion

        //region Botones regresar y Guardar

        btnRegresar.setOnClickListener()
        {
            val lanzar = Intent(this, MainActivity::class.java)
            startActivity(lanzar)
        }

        btnGuardarConfig.setOnClickListener() {
            configDao.AddConfig(chk1.isChecked,chk2.isChecked,chk3.isChecked,chk4.isChecked,chk5.isChecked,chk6.isChecked,switchPistas.isChecked,spinner.selectedItemPosition+1,ExSeekBar.progress)
        }

        //endregion

    }

}

