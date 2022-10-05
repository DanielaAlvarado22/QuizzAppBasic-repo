package com.example.quizzappbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.graphics.Color
import android.widget.Toast
import androidx.activity.viewModels

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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val gameModel: GameModel by viewModels()

        txtQuestion = findViewById(R.id.txtQuestion)
        btnNext = findViewById(R.id.btnNext)
        btnPrev = findViewById(R.id.btnPrev)
        btnResp1 = findViewById(R.id.btnresp1)
        btnResp2 = findViewById(R.id.btnresp2)
        btnResp3 = findViewById(R.id.btnresp3)
        btnResp4 = findViewById(R.id.btnresp4)
        txtIndex = findViewById(R.id.txtIndex)
        txtsizeIndex = findViewById(R.id.txtsizeIndex)

        txtQuestion.text = gameModel.currentQuestionText
        txtIndex.text = gameModel.Totalindex
        txtsizeIndex.text = gameModel.sizeIndex

        btnResp1.text = gameModel.currentQuestionAnswer
        btnResp2.text = gameModel.currentQuestionAnswerBad1
        btnResp3.text = gameModel.currentQuestionAnswerBad2
        btnResp4.text = gameModel.currentQuestionAnswerBad3

        val listAnsw = mutableListOf<Button>(btnResp1, btnResp2, btnResp3, btnResp4)
        val shuffAnsw = listAnsw.shuffled()

        btnResp1 = shuffAnsw.elementAt(0)
        btnResp2 = shuffAnsw.elementAt(1)
        btnResp3 = shuffAnsw.elementAt(2)
        btnResp4 = shuffAnsw.elementAt(3)

        btnResp1.setOnClickListener { v ->
            if(!gameModel.isAnswered()){
                if(gameModel.compare(btnResp1.text.toString())){
                    Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
                    btnResp1.setTextColor(Color.GREEN)
                    btnResp2.isEnabled = false
                    btnResp3.isEnabled = false
                    btnResp4.isEnabled = false
                }else{
                    Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
                    btnResp1.setTextColor(Color.RED)
                    btnResp2.isEnabled = false
                    btnResp3.isEnabled = false
                    btnResp4.isEnabled = false
                }
            }
        }
        btnResp2.setOnClickListener { v ->
            if(!gameModel.isAnswered()){
                if(gameModel.compare(btnResp2.text.toString())){
                    Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
                    btnResp2.setTextColor(Color.GREEN)
                    btnResp1.isEnabled = false
                    btnResp3.isEnabled = false
                    btnResp4.isEnabled = false
                }else{
                    Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
                    btnResp2.setTextColor(Color.RED)
                    btnResp1.isEnabled = false
                    btnResp3.isEnabled = false
                    btnResp4.isEnabled = false
                }
            }
        }
        btnResp3.setOnClickListener { v ->
            if(!gameModel.isAnswered()){
                if(gameModel.compare(btnResp3.text.toString())){
                    Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
                    btnResp3.setTextColor(Color.GREEN)
                    btnResp1.isEnabled = false
                    btnResp2.isEnabled = false
                    btnResp4.isEnabled = false
                }else{
                    Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
                    btnResp3.setTextColor(Color.RED)
                    btnResp1.isEnabled = false
                    btnResp2.isEnabled = false
                    btnResp4.isEnabled = false
                }
            }
        }
        btnResp4.setOnClickListener { v ->
            if(!gameModel.isAnswered()){
                if(gameModel.compare(btnResp4.text.toString())){
                    Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
                    btnResp4.setTextColor(Color.GREEN)
                    btnResp1.isEnabled = false
                    btnResp2.isEnabled = false
                    btnResp3.isEnabled = false
                } else{
                    Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
                    btnResp4.setTextColor(Color.RED)
                    btnResp1.isEnabled = false
                    btnResp2.isEnabled = false
                    btnResp3.isEnabled = false
                }
            }
        }



        btnPrev.setOnClickListener { v ->
            gameModel.prevQuestion()
            txtQuestion.text = gameModel.currentQuestionText


            txtIndex.text = gameModel.Totalindex

        }

        btnNext.setOnClickListener { v ->

            btnResp1.setTextColor(Color.WHITE)
            btnResp2.setTextColor(Color.WHITE)
            btnResp3.setTextColor(Color.WHITE)
            btnResp4.setTextColor(Color.WHITE)

            btnResp1.isEnabled = true
            btnResp2.isEnabled = true
            btnResp3.isEnabled = true
            btnResp4.isEnabled = true


            gameModel.nextQuestion()
            txtQuestion.text = gameModel.currentQuestionText

            btnResp1.text = gameModel.currentQuestionAnswer
            btnResp2.text = gameModel.currentQuestionAnswerBad1
            btnResp3.text = gameModel.currentQuestionAnswerBad2
            btnResp4.text = gameModel.currentQuestionAnswerBad3

            val listAnsw = mutableListOf<Button>(btnResp1, btnResp2, btnResp3, btnResp4)
            val shuffAnsw = listAnsw.shuffled()

            btnResp1 = shuffAnsw.elementAt(0)
            btnResp2 = shuffAnsw.elementAt(1)
            btnResp3 = shuffAnsw.elementAt(2)
            btnResp4 = shuffAnsw.elementAt(3)

            txtIndex.text = gameModel.Totalindex

            btnResp1.setOnClickListener { v ->
                if(!gameModel.isAnswered()){
                    if(gameModel.compare(btnResp1.text.toString())){
                        Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
                        btnResp1.setTextColor(Color.GREEN)
                        btnResp2.isEnabled = false
                        btnResp3.isEnabled = false
                        btnResp4.isEnabled = false
                    }else{
                        Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
                        btnResp1.setTextColor(Color.RED)
                        btnResp2.isEnabled = false
                        btnResp3.isEnabled = false
                        btnResp4.isEnabled = false
                    }
                }
            }
            btnResp2.setOnClickListener { v ->
                if(!gameModel.isAnswered()){
                    if(gameModel.compare(btnResp2.text.toString())){
                        Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
                        btnResp2.setTextColor(Color.GREEN)
                        btnResp1.isEnabled = false
                        btnResp3.isEnabled = false
                        btnResp4.isEnabled = false
                    }else{
                        Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
                        btnResp2.setTextColor(Color.RED)
                        btnResp1.isEnabled = false
                        btnResp3.isEnabled = false
                        btnResp4.isEnabled = false
                    }
                }
            }
            btnResp3.setOnClickListener { v ->
                if(!gameModel.isAnswered()){
                    if(gameModel.compare(btnResp3.text.toString())){
                        Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
                        btnResp3.setTextColor(Color.GREEN)
                        btnResp1.isEnabled = false
                        btnResp2.isEnabled = false
                        btnResp4.isEnabled = false
                    }else{
                        Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
                        btnResp3.setTextColor(Color.RED)
                        btnResp1.isEnabled = false
                        btnResp2.isEnabled = false
                        btnResp4.isEnabled = false
                    }
                }
            }
            btnResp4.setOnClickListener { v ->
                if(!gameModel.isAnswered()){
                    if(gameModel.compare(btnResp4.text.toString())){
                        Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
                        btnResp4.setTextColor(Color.GREEN)
                        btnResp1.isEnabled = false
                        btnResp2.isEnabled = false
                        btnResp3.isEnabled = false
                    } else{
                        Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
                        btnResp4.setTextColor(Color.RED)
                        btnResp1.isEnabled = false
                        btnResp2.isEnabled = false
                        btnResp3.isEnabled = false
                    }
                }
            }

        }


    }
}