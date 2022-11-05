package com.example.quizzappbasic.daos

import androidx.room.*
import com.example.quizzappbasic.Question
import com.example.quizzappbasic.tables.gameInfo

@Dao
interface QuestionsDao {

    @Query("SELECT * FROM questions")
    fun GetAllQuestions(): List<Question>

    @Query("SELECT * FROM questions WHERE questionId = :id")
    fun GetQuestion(id:Int): Question

    @Query("SELECT * FROM questions ORDER BY tema")
    fun GetQuestionsByTema(): List<Question>

    @Transaction
    @Query("SELECT * FROM questions WHERE tema in(:temas) ")
    fun GetQuestionsByTemas(temas: List<String>): List<Question>


    @Insert
    fun AddQuestion(question: Question)

    @Insert
    fun AddQuestions(question: List<Question>)

    @Query("INSERT INTO questions_temas (gameId, questionId) values (:gameid,:questionid)")
    fun AddQuestionTema(gameid: Int, questionid: Int)

}