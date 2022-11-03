package com.example.quizzappbasic

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class gameConfig(@Embedded val GameInfo: Question,
                      @Relation(
                          parentColumn = "questionId",
                          entityColumn = "questionId",
                      )
                      val answers: List<Answer>)

