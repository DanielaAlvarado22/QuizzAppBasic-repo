package com.example.quizzappbasic.tables

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "gameInfo")

data class gameInfo(@PrimaryKey (autoGenerate = true) val gameId:Int,
                    val isFinished:Boolean,
                    val isStarted:Boolean,
                    val puntosFinales:Int,
                    val player:String
                    )
