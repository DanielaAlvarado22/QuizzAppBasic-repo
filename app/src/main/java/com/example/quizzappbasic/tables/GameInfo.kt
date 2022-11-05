package com.example.quizzappbasic.tables

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "gameInfo")

data class gameInfo(@PrimaryKey (autoGenerate = true) val gameId:Int,
                    var isFinished:Boolean,
                    var isStarted:Boolean,
                    var puntosFinales:Int,
                    val player:String
                    )
