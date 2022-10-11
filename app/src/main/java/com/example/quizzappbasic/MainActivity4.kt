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
    private lateinit var txtRes : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val bundle = intent.extras
        val dato = bundle?.getInt(PUNTAJE)
        val dato2 = bundle?.getInt(HINTS_USADAS)

        ImgImagen = findViewById(R.id.imgResultados)
        txtRes = findViewById(R.id.txtRes)

        txtPuntajeFinal = findViewById(R.id.txtPuntajeFinal)
        txtPuntajeFinal.text = "Puntaje final: ${dato}"

        txtPuntosMenosHints = findViewById(R.id.txtPuntosMenosHints)
        txtPuntosMenosHints.text = "Puntos malos por hints: ${dato2}"


        //region CAMBIO IMAGEVIEW

        if (dato != null) {
            if(dato < 60){
                ImgImagen.setImageResource(R.drawable.morty2)
                txtRes.text = "TU PUEDES HACERLO MEJOR :("

            }
        }

        if (dato != null) {
            if(dato > 60 && dato <= 150){
                ImgImagen.setImageResource(R.drawable.morty3)
                txtRes.text = "ESTUDIA TANTITO MASS :)"

            }
        }

        if (dato != null) {
            if(dato > 150){
                ImgImagen.setImageResource(R.drawable.morty1)
                txtRes.text = "ERESSS UN PROO :3"
            }
        }

//endregion
    }
}