package com.example.quizzappbasic

import androidx.room.*

@Dao
interface QuestionsDao {


    @Query("SELECT * FROM questions WHERE id = :id")
    fun GetQuestion(id:Int): Question

    @Query("SELECT * FROM questions ORDER BY id")
    fun GetQuestions(): List<Question>

    @Insert
    fun AddQuestion(question: Question)

    @Insert
    fun AddQuestions(question: List<Question>)
}