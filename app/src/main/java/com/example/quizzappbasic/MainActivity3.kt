package com.example.quizzappbasic

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.quizzappbasic.daos.GameDataBase

val PUNTAJE = "PUNTAJE"
val HINTS_USADAS = "HINTS_USADAS"
class MainActivity3 : AppCompatActivity() {

    private lateinit var txtQuestion: TextView
    private lateinit var btnNext: Button
    private lateinit var btnPrev: Button
    private lateinit var btnResp1: Button
    private lateinit var btnResp2: Button
    private lateinit var btnResp3: Button
    private lateinit var btnResp4: Button
    private lateinit var txtIndex: TextView
    private lateinit var txtsizeIndex: TextView
    private lateinit var txtTema: TextView
    private lateinit var txtContestada: TextView
    private lateinit var txtHints: TextView
    private lateinit var txtDiff: TextView
    private lateinit var txtUsasteHints: TextView
    private lateinit var btnHints: Button
    var indexHints = 0
    var respuestasEliminadas = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val db = Room.databaseBuilder(
            applicationContext,
            GameDataBase::class.java, "quizapp")
            .allowMainThreadQueries()
            .build()

        val gameDao = db.GameInfoDao()
        val configDao = db.configDao()
        var currentGame = gameDao.getLastGame()
        if (!currentGame.isStarted){
            currentGame.isStarted = true
        }

        gameDao.UpdateGame(currentGame)

        var currentConfig = configDao.GetLastConfig()
        var dificultadIndex = currentConfig.spinn
        var pistasEnabled = currentConfig.pistas

        val gameModel: GameModel by viewModels()
//region asignaciones
        txtQuestion = findViewById(R.id.txtQuestion)
        btnNext = findViewById(R.id.btnNext)
        btnPrev = findViewById(R.id.btnPrev)
        btnResp1 = findViewById(R.id.btnresp1)
        btnResp2 = findViewById(R.id.btnresp2)
        btnResp3 = findViewById(R.id.btnresp3)
        btnResp4 = findViewById(R.id.btnresp4)
        txtIndex = findViewById(R.id.txtIndex)
        txtContestada = findViewById(R.id.txtContestada)
        txtsizeIndex = findViewById(R.id.txtsizeIndex)
        txtTema = findViewById(R.id.txtTema)
        txtHints = findViewById(R.id.txtHints)
        btnHints = findViewById(R.id.btnHint)
        txtUsasteHints = findViewById((R.id.txtUsasteHints))
        if(!pistasEnabled){
            btnHints.isEnabled = false
            txtHints.isEnabled = false
            txtUsasteHints.isEnabled = false
        }
        //ASIGNANDO LAS PREGUNTAS SHUFLEADAS AL GAME MODEL PARA LA LOGICA
        gameModel.shuffQuestions = db.questionsDao().getCurrentGameQuestions(currentGame.gameId)

        txtQuestion.text = gameModel.currentQuestionText
        txtIndex.text = gameModel.Totalindex
        txtsizeIndex.text = gameModel.sizeIndex
        txtTema.text = gameModel.currentQuestionTema
        txtHints.text = "Hints restantes: " + gameModel.HintsTotal.toString()

        var listaBtn = mutableListOf<Button>(btnResp1, btnResp2, btnResp3, btnResp4)

        var difText = ""
        if(dificultadIndex==1){difText = "Facil"}
        if(dificultadIndex==2){difText = "Normal"}
        if(dificultadIndex==3){difText = "Dificil"}

        //txtdif.text = dato


//endregion

        //lamar funcion para checar la dificultad
        OpcDific(gameModel, difText)

//region HINTS
        btnHints.setOnClickListener {

            gameModel.lessPointsHints()
            gameModel.MalosPuntos()
            gameModel.MostarUsoHint()

            if(gameModel.UsasteHints == true){
                txtUsasteHints.text = "En esta pregunta usaste hints"
            }


            if (indexHints == 2) {

                if (btnResp1.text == gameModel.currentQuestionAnswer) {
                    btnResp1.performClick()
                    gameModel.disminHints()
                }
                if (btnResp2.text == gameModel.currentQuestionAnswer) {
                    btnResp2.performClick()
                    gameModel.disminHints()
                }

            }


            if (indexHints == 3) {
                if (gameModel.HintsTotal > 0) {
                    for (i in 0..2) {
                        if (listaBtn[i].text == gameModel.currentQuestionAnswer && respuestasEliminadas == 1) {
                            listaBtn[i].performClick()
                            gameModel.disminHints()
                            break
                        }
                        if (listaBtn[i].text != gameModel.currentQuestionAnswer && respuestasEliminadas < 1 && listaBtn[i].isClickable) {
                            listaBtn[i].isClickable = false
                            listaBtn[i].setBackgroundColor(Color.LTGRAY)
                            gameModel.disminHints()
                            respuestasEliminadas++
                            break
                        }
                    }
                }


            }

            if (indexHints == 4) {

                if (gameModel.HintsTotal > 0) {
                    for (i in 0..3) {
                        if (listaBtn[i].text == gameModel.currentQuestionAnswer && respuestasEliminadas == 2) {
                            listaBtn[i].performClick()
                            gameModel.disminHints()
                            break
                        }
                        if (listaBtn[i].text != gameModel.currentQuestionAnswer && respuestasEliminadas <= 1 && listaBtn[i].isClickable) {
                            listaBtn[i].isClickable = false
                            listaBtn[i].setBackgroundColor(Color.LTGRAY)
                            gameModel.disminHints()
                            respuestasEliminadas++
                            break
                        }
                    }
                }

            }

            txtHints.text = "Hints restantes: " + gameModel.HintsTotal.toString()
        }


        //endregion HINTS

//region btn next y prev
        btnNext.setOnClickListener { v ->
            if(gameModel.obtenerContestadas == 5){
                currentGame.puntosFinales = gameModel.points
                currentGame.isFinished = true
                gameDao.UpdateGame(currentGame)
                val lanzar = Intent(this, MainActivity4::class.java)
                lanzar.putExtra(PUNTAJE,currentGame.puntosFinales)
                lanzar.putExtra(HINTS_USADAS,gameModel.MenosPorHints)
                startActivity(lanzar)
            }
            gameModel.nextQuestion()
            txtQuestion.text = gameModel.currentQuestionText
            respuestasEliminadas = 0
            randomizeAnswers(gameModel, listaBtn)
            OpcDific(gameModel, difText)
            txtIndex.text = gameModel.Totalindex
            txtTema.text = gameModel.currentQuestionTema

            if(gameModel.UsasteHints == true){
                txtUsasteHints.text = "En esta pregunta usaste hints"
            }else {txtUsasteHints.text =""}

            //si contestadas del game model es igual la cant de preg de la config actual
            //if(gameModel.obtenerContestadas == currentConfig.cantPreguntas){
        }

        btnPrev.setOnClickListener { v ->
            gameModel.prevQuestion()
            txtQuestion.text = gameModel.currentQuestionText

            randomizeAnswers(gameModel, listaBtn)
            OpcDific(gameModel, difText)

            txtIndex.text = gameModel.Totalindex
            txtTema.text = gameModel.currentQuestionTema

            if(gameModel.UsasteHints == true){
                txtUsasteHints.text = "En esta pregunta usaste hints"
            } else {txtUsasteHints.text =""}
        }


        //endregion



//region botonesrespuesta
        btnResp1.setOnClickListener { v ->
            validateAnswers(gameModel, btnResp1,listaBtn)
        }
        btnResp2.setOnClickListener { v ->
            validateAnswers(gameModel, btnResp2,listaBtn)
        }
        btnResp3.setOnClickListener { v ->
            validateAnswers(gameModel, btnResp3,listaBtn)
        }
        btnResp4.setOnClickListener { v ->
            validateAnswers(gameModel, btnResp4,listaBtn)
        }


//endregion




    }

    private fun validateAnswers(gameModel: GameModel, currBtn: Button,listaBtn: MutableList<Button>) {
        if (!gameModel.answered) {
            if (gameModel.compare(currBtn.text.toString())) {
                Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
                currBtn.setTextColor(Color.GREEN)
                gameModel.addPoints()
                gameModel.shuffQuestions[gameModel.currentIndex].answered = true
                gameModel.shuffQuestions[gameModel.currentIndex].answeredCorrectly = 1
                if(gameModel.hintsConsecutivas < 2){
                    gameModel.aumentHintsConsect()
                }
                if(gameModel.hintsConsecutivas == 2){
                    gameModel.aumentHints()
                    txtHints.text = "Hints restantes: " + gameModel.HintsTotal.toString()
                    gameModel.restartHintsConsect()
                }


            } else {
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
                currBtn.setTextColor(Color.RED)
                gameModel.popPoints()
                gameModel.restartHintsConsect()
                gameModel.shuffQuestions[gameModel.currentIndex].answered = true
                gameModel.shuffQuestions[gameModel.currentIndex].answeredCorrectly = 2

            }
            gameModel.Contestadas()

        } else {

            Toast.makeText(this, "Ya la contestaste", Toast.LENGTH_SHORT).show()
            for (i in 0..3) {
                listaBtn[i].isEnabled = false
            }
        }
    }

    private fun randomizeAnswers(gameModel: GameModel, listaBtn: MutableList<Button>) {
        if (!gameModel.answered) {
            var respuestas = listOf<String>(
                gameModel.currentQuestionAnswer,
                gameModel.currentQuestionAnswerBad1,
                gameModel.currentQuestionAnswerBad2,
                gameModel.currentQuestionAnswerBad3
            )
            var respuestasShuffled = respuestas.shuffled()
            btnResp1.text = respuestasShuffled[0]
            btnResp2.text = respuestasShuffled[1]
            btnResp3.text = respuestasShuffled[2]
            btnResp4.text = respuestasShuffled[3]

            for (i in 0..3) {
                listaBtn[i].isEnabled = true
                listaBtn[i].isClickable = true
                listaBtn[i].setBackgroundColor(Color.parseColor("#193255"))
                listaBtn[i].setTextColor(Color.WHITE)
            }

            if (gameModel.shuffQuestions[gameModel.currentIndex].answeredCorrectly == 0) {
                txtContestada.text = ""
            }

        } else {
            if (gameModel.shuffQuestions[gameModel.currentIndex].answeredCorrectly == 1) {
                txtContestada.text = "Ya la conestaste CORRECTAMENTE"
                txtContestada.setTextColor(Color.GREEN)
            }
            if (gameModel.shuffQuestions[gameModel.currentIndex].answeredCorrectly == 2) {
                txtContestada.text = "Ya la contestaste INCORRECTAMENTE"
                txtContestada.setTextColor(Color.RED)
            }

            for (i in 0..3) {
                listaBtn[i].isEnabled = false
                listaBtn[i].setTextColor(Color.TRANSPARENT)
            }

        }


    }

    private fun OpcDific(gameModel: GameModel, dato: String?) {
        if (dato == "Facil") {
            var respuestas =
                listOf<String>(gameModel.currentQuestionAnswer, gameModel.currentQuestionAnswerBad2)
            var respuestasShuffled = respuestas.shuffled()
            btnResp1.text = respuestasShuffled[0]
            btnResp2.text = respuestasShuffled[1]
            btnResp3.visibility = View.INVISIBLE
            btnResp4.visibility = View.INVISIBLE
            indexHints = 2

        }

        if (dato == "Normal") {

            var respuestas = listOf<String>(
                gameModel.currentQuestionAnswer,
                gameModel.currentQuestionAnswerBad1,
                gameModel.currentQuestionAnswerBad3
            )
            var respuestasShuffled = respuestas.shuffled()
            btnResp1.text = respuestasShuffled[0]
            btnResp2.text = respuestasShuffled[1]
            btnResp3.text = respuestasShuffled[2]
            btnResp4.visibility = View.INVISIBLE
            indexHints = 3
        }

        if (dato == "Dificil") {
            var respuestas = listOf<String>(
                gameModel.currentQuestionAnswer,
                gameModel.currentQuestionAnswerBad1,
                gameModel.currentQuestionAnswerBad2,
                gameModel.currentQuestionAnswerBad3
            )
            var respuestasShuffled = respuestas.shuffled()
            btnResp1.text = respuestasShuffled[0]
            btnResp2.text = respuestasShuffled[1]
            btnResp3.text = respuestasShuffled[2]
            btnResp4.text = respuestasShuffled[3]
            indexHints = 4
        }


    }


}