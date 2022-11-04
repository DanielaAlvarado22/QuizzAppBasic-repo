package com.example.quizzappbasic

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

data class gameConfig(@Embedded val GameInfo: gameInfo,
                      @Relation(
                          parentColumn = "id",
                          entityColumn = "id"
                      )
                      val gameConfig: Config)

