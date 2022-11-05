package com.example.quizzappbasic

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "QuestionTemas")
data class QuestionsTemas(@PrimaryKey val idJuego:Int,
                          val preguntas : List<Question>)
