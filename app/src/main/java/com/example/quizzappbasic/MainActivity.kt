package com.example.quizzappbasic

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.room.Room

class MainActivity : AppCompatActivity() {

//    lateinit var dificultad : MutableList<String>
//    lateinit var spinner : Spinner
//    lateinit var dif: String
    lateinit var btnOpciones :Button
    lateinit var btnJugar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bundle = intent.extras
        val dato = bundle?.getString("DIFICULTAD")

        val gameModel: GameModel by viewModels()

        val db = Room.databaseBuilder(
            applicationContext,
            GameDataBase::class.java, "quizapp")
            .allowMainThreadQueries()
            .build()



        val questionsDao = db.questionsDao()
        questionsDao.AddQuestions(gameModel.Preguntas)


        btnOpciones = findViewById(R.id.btnOpciones)
        btnOpciones.setOnClickListener {
            val lanzar = Intent(this, MainActivity2::class.java)
            startActivity(lanzar)
        }

        btnJugar = findViewById(R.id.btnJugar)
        btnJugar.setOnClickListener {

            val lanzar = Intent(this, MainActivity3::class.java)
            lanzar.putExtra("DIFICULTAD",dato.toString())
            startActivity(lanzar)
        }

    }
}