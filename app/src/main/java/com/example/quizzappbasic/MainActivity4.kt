package com.example.quizzappbasic

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity4 : AppCompatActivity() {

    private lateinit var txtPuntajeFinal : TextView
    private lateinit var txtPuntosMenosHints : TextView
    private lateinit var ImgImagen : ImageView
    private lateinit var BtnCambio : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val bundle = intent.extras
        val dato = bundle?.getInt(PUNTAJE)
        val dato2 = bundle?.getInt(HINTS_USADAS)

        ImgImagen = findViewById(R.id.imgResultados)
        BtnCambio = findViewById(R.id.btnCambio)

        txtPuntajeFinal = findViewById(R.id.txtPuntajeFinal)
        txtPuntajeFinal.text = "Puntaje final: ${dato}"

        txtPuntosMenosHints = findViewById(R.id.txtPuntosMenosHints)
        txtPuntosMenosHints.text = "Puntos malos por hints: ${dato2}"

        BtnCambio.setOnClickListener {
            ImgImagen.setImageResource(R.drawable.mantenimiento)
        }

        if (dato != null) {
            if(dato > 60 && dato <= 150){
                ImgImagen.setImageResource(R.drawable.mantenimiento)

            }
        }


    }
}