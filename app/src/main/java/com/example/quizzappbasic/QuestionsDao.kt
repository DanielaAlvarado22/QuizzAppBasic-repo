package com.example.quizzappbasic

import androidx.room.*

@Dao
interface QuestionsDao {


    @Query("SELECT * FROM questions WHERE id = :id")
    fun GetQuestion(id:Int): Question

    @Query("SELECT * FROM questions ORDER BY tema")
    fun GetQuestionsByTema(): List<Question>

    @Query("SELECT * FROM questions WHERE tema=:tema")
    fun GetQuestionFiltered(tema:String): List<Question>

    @Insert
    fun AddQuestion(question: Question)

    @Insert
    fun AddQuestions(question: List<Question>)

    @Insert
    fun AddQuestionTema(idJuego:Int, questions: List<Question>)

}