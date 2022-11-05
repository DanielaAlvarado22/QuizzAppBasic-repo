package com.example.quizzappbasic.tables

import androidx.room.*
import com.example.quizzappbasic.Question


data class QuestionsTemas(
    @Embedded val game: gameInfo,
    @Relation(
        parentColumn = "gameId",
        entityColumn = "questionId",
        associateBy = Junction(QuestionTemasRef::class)
    )
    val preguntas: List<Question>
    )
