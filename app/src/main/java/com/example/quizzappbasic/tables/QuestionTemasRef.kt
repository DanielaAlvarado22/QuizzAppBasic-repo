package com.example.quizzappbasic.tables

import androidx.room.Entity

@Entity(primaryKeys = ["gameId","questionId"], tableName = "questions_temas")
data class QuestionTemasRef(
    val gameId: Int,
    val questionId: Int
)
