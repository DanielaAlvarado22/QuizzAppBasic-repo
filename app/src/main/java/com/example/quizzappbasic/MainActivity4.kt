package com.example.quizzappbasic

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.room.Room
import com.example.quizzappbasic.daos.GameDataBase
import org.w3c.dom.Text

class MainActivity4 : AppCompatActivity() {

    private lateinit var txtPuntajeFinal : TextView
    private lateinit var txtPuntosMenosHints : TextView
   // private lateinit var ImgImagen : ImageView
    //private lateinit var txtRes : TextView
    lateinit var txt_top1: TextView
    lateinit var txt_top2: TextView
    lateinit var txt_top3: TextView
    lateinit var txt_top4: TextView
    lateinit var txt_top5: TextView
    lateinit var ll_scores: LinearLayout
    lateinit var btnInicio: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val db = Room.databaseBuilder(
            applicationContext,
            GameDataBase::class.java, "quizapp")
            .allowMainThreadQueries()
            .build()

        val gameDao = db.GameInfoDao()
        var currentGame = gameDao.getLastGame()
        var topPuntajes = gameDao.getTop5PuntajesFinales()
        var puntajeActual = gameDao.getPuntajeActual(currentGame.gameId)

        val bundle = intent.extras
        val dato = bundle?.getInt(PUNTAJE)
        val dato2 = bundle?.getInt(HINTS_USADAS)

//        ImgImagen = findViewById(R.id.imgResultados)
//        txtRes = findViewById(R.id.txtRes)

        txtPuntajeFinal = findViewById(R.id.txtPuntajeFinal)
        txtPuntajeFinal.text = "Puntaje final: ${puntajeActual}"

        txtPuntosMenosHints = findViewById(R.id.txtPuntosMenosHints)
        txtPuntosMenosHints.text = "Puntos malos por hints: ${dato2}"

        txt_top1 = findViewById(R.id.txt_top1)
        txt_top2 = findViewById(R.id.txt_top2)
        txt_top3 = findViewById(R.id.txt_top3)
        txt_top4 = findViewById(R.id.txt_top4)
        txt_top5 = findViewById(R.id.txt_top5)
        ll_scores = findViewById(R.id.linear_scores)

        var topList = listOf<TextView>(txt_top1,txt_top2,txt_top3,txt_top4,txt_top5)

        for(index in 0..4){
            topList[index].text = "${index+1}   -    ${topPuntajes[index]}   -   DAR"
        }

        btnInicio = findViewById(R.id.btn_regresar)
        btnInicio.setOnClickListener {
            val act1 = Intent(this,MainActivity::class.java)
            startActivity(act1)
        }

        //region CAMBIO IMAGEVIEW

//        if (dato != null) {
//            if(dato < 60){
//                ImgImagen.setImageResource(R.drawable.morty2)
//                txtRes.text = "TU PUEDES HACERLO MEJOR :("
//
//            }
//        }

//        if (dato != null) {
//            if(dato > 60 && dato <= 150){
//                ImgImagen.setImageResource(R.drawable.morty3)
//                txtRes.text = "ESTUDIA TANTITO MASS :)"
//
//            }
//        }
//
//        if (dato != null) {
//            if(dato > 150){
//                ImgImagen.setImageResource(R.drawable.morty1)
//                txtRes.text = "ERESSS UN PROO :3"
//            }
//        }

//endregion
    }
}