package com.example.quizzappbasic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.core.view.isGone
import androidx.room.Room
import com.example.quizzappbasic.daos.GameDataBase
import com.example.quizzappbasic.daos.QuestionsDao

class MainActivity : AppCompatActivity() {

    lateinit var btnOpciones :Button
    lateinit var btnJugar : Button
    lateinit var btnPuntuaciones : Button
    lateinit var btn_Continuar : Button
    lateinit var btnPuntos : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gameModel: GameModel by viewModels()

        val db = Room.databaseBuilder(
            applicationContext,
            GameDataBase::class.java, "quizapp")
            .allowMainThreadQueries()
            .build()



        val questionsDao = db.questionsDao()
//        questionsDao.AddQuestions(gameModel.Preguntas)

        val configDao = db.configDao()
        val GameInfoDao = db.GameInfoDao()

        val lastConfig = configDao.GetLastConfig()




        btnOpciones = findViewById(R.id.btnOpciones)
        btnOpciones.setOnClickListener {
            val lanzar = Intent(this, MainActivity2::class.java)
            startActivity(lanzar)
        }

        var preguntasFiltradas: List<Question>
        var temas = mutableListOf<String>()
        btnJugar = findViewById(R.id.btnJugar)
        btnJugar.setOnClickListener {

            GameInfoDao.AddGameInfo(false,true,0,"DVS")
            var lastGame = GameInfoDao.getLastGame()
            GameInfoDao.AddGameConfig(lastGame.gameId,lastConfig.id)
            if(lastConfig.checkBox6){//todas
                temas.add("Entretenimiento")
                temas.add("Animales")
                temas.add("Cultura general")
                temas.add("Historia de México")
                temas.add("Videojuegos")
            }else  {
                if(lastConfig.checkBox){//entretenimiento
                    temas.add("Entretenimiento")
                }
                if(lastConfig.checkBox2){//animales
                    temas.add("Cultura general")
                }
                if(lastConfig.checkBox3){//cultura
                    temas.add("Animales")
                }
                if(lastConfig.checkBox4){//historia
                    temas.add("Historia de México")
                }
                if(lastConfig.checkBox5){//videojuegos
                    temas.add("Videojuegos")
                }
            }
            preguntasFiltradas = questionsDao.GetQuestionsByTemas(temas)
            preguntasFiltradas.shuffled()
            var preguntas = mutableListOf<Question>()
            for ( index in 0..lastConfig.cantPreguntas-1){
                preguntas.add(preguntasFiltradas[index])
                questionsDao.AddQuestionTema(lastGame.gameId, preguntas[index].questionId)
            }
            val lanzar = Intent(this, MainActivity3::class.java)
            startActivity(lanzar)
        }

        btn_Continuar = findViewById(R.id.btnContinuar)

//        var lastGame = GameInfoDao.getLastGame()
//        if(lastGame.isStarted){
//            btn_Continuar.isGone = false
//        }else{
//            true
//        }


        btn_Continuar.setOnClickListener {
            val act3 = Intent(this,MainActivity3::class.java)
            startActivity(act3)
        }

        btnPuntos = findViewById(R.id.btnPuntos)

        btnPuntos.setOnClickListener {
            val act5 = Intent(this,MainActivity5::class.java)
            startActivity(act5)
        }

    }
}