package com.example.quizzappbasic

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {

    private lateinit var txtQuestion : TextView
    private lateinit var btnNext : Button
    private lateinit var btnPrev : Button
    private lateinit var btnResp1 :Button
    private lateinit var btnResp2 :Button
    private lateinit var btnResp3 :Button
    private lateinit var btnResp4 :Button
    private lateinit var txtIndex : TextView
    private lateinit var txtsizeIndex : TextView
    private lateinit var txtdif: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val bundle = intent.extras
        val dato = bundle?.getString("DIFICULTAD")

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
        txtsizeIndex = findViewById(R.id.txtsizeIndex)
        txtdif = findViewById(R.id.txtdif)
        txtQuestion.text = gameModel.currentQuestionText
        txtIndex.text = gameModel.Totalindex
        txtsizeIndex.text = gameModel.sizeIndex

//        txtdif.text = dato


//endregion

        var respuestas = listOf<String>(gameModel.currentQuestionAnswer, gameModel.currentQuestionAnswerBad1, gameModel.currentQuestionAnswerBad2, gameModel.currentQuestionAnswerBad3 )
        var respuestasShuffled = respuestas.shuffled()
        btnResp1.text = respuestasShuffled[0]
        btnResp2.text = respuestasShuffled[1]
        btnResp3.text = respuestasShuffled[2]
        btnResp4.text = respuestasShuffled[3]

//region btn next y prev
        btnNext.setOnClickListener { v ->
            gameModel.nextQuestion()
            txtQuestion.text = gameModel.currentQuestionText

            randomizeAnswers(gameModel)

            txtIndex.text = gameModel.Totalindex
        }

        btnPrev.setOnClickListener { v ->
            gameModel.prevQuestion()
            txtQuestion.text = gameModel.currentQuestionText

            randomizeAnswers(gameModel)

            txtIndex.text = gameModel.Totalindex
        }


        //endregion

//region botonesrespuesta
        btnResp1.setOnClickListener { v ->
            validateAnswers(gameModel, btnResp1)
        }
        btnResp2.setOnClickListener { v ->
            validateAnswers(gameModel, btnResp2)
        }
        btnResp3.setOnClickListener { v ->
            validateAnswers(gameModel, btnResp3)
        }
        btnResp4.setOnClickListener { v ->
            validateAnswers(gameModel, btnResp4)
        }


//endregion


    }

    private fun validateAnswers(gameModel: GameModel, currBtn: Button) {
        if(!gameModel.answered){
            if(gameModel.compare(currBtn.text.toString())){
                Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
                currBtn.setTextColor(Color.GREEN)
                gameModel.addPoints()
                gameModel.shuffQuestions[gameModel.currentIndex].answered = true
                gameModel.shuffQuestions[gameModel.currentIndex].answeredCorrectly = 1
            }else{
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
                currBtn.setTextColor(Color.RED)
                gameModel.popPoints()
                gameModel.shuffQuestions[gameModel.currentIndex].answered = true
                gameModel.shuffQuestions[gameModel.currentIndex].answeredCorrectly = 2
            }

        }else{

            Toast.makeText(this, "Ya la contestaste", Toast.LENGTH_SHORT).show()
            btnResp1.isEnabled = false
            btnResp2.isEnabled = false
            btnResp3.isEnabled = false
            btnResp4.isEnabled = false
        }
    }

    private fun randomizeAnswers(gameModel: GameModel){
        if(!gameModel.answered){
            var respuestas = listOf<String>(gameModel.currentQuestionAnswer, gameModel.currentQuestionAnswerBad1, gameModel.currentQuestionAnswerBad2, gameModel.currentQuestionAnswerBad3 )
            var respuestasShuffled = respuestas.shuffled()
            btnResp1.text = respuestasShuffled[0]
            btnResp2.text = respuestasShuffled[1]
            btnResp3.text = respuestasShuffled[2]
            btnResp4.text = respuestasShuffled[3]

            btnResp1.isEnabled = true
            btnResp2.isEnabled = true
            btnResp3.isEnabled = true
            btnResp4.isEnabled = true
            btnResp1.setTextColor(Color.WHITE)
            btnResp2.setTextColor(Color.WHITE)
            btnResp3.setTextColor(Color.WHITE)
            btnResp4.setTextColor(Color.WHITE)

        }else{
            if(gameModel.shuffQuestions[gameModel.currentIndex].answeredCorrectly == 1){
                Toast.makeText(this, "Ya la contestaste CORRECTAMENTE", Toast.LENGTH_SHORT).show()
            }
            if(gameModel.shuffQuestions[gameModel.currentIndex].answeredCorrectly == 2){
                Toast.makeText(this, "Ya la contestaste MAL!!!!", Toast.LENGTH_SHORT).show()
            }

            btnResp1.isEnabled = false
            btnResp2.isEnabled = false
            btnResp3.isEnabled = false
            btnResp4.isEnabled = false
            btnResp1.setTextColor(Color.TRANSPARENT)
            btnResp2.setTextColor(Color.TRANSPARENT)
            btnResp3.setTextColor(Color.TRANSPARENT)
            btnResp4.setTextColor(Color.TRANSPARENT)
        }
    }




}