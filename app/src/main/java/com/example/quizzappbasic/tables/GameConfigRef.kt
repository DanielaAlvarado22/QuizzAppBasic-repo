package com.example.quizzappbasic.tables

import androidx.room.*
import com.example.quizzappbasic.tables.Config
import com.example.quizzappbasic.tables.gameConfig
import com.example.quizzappbasic.tables.gameInfo

data class gameConfigRef(@Embedded val GameInfo: gameInfo,
                         @Relation(
                          parentColumn = "id",
                          entityColumn = "id",
                         associateBy = Junction(gameConfig::class)
                      )
                      val config: Config
)

