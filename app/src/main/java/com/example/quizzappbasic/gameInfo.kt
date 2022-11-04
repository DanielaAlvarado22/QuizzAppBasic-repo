package com.example.quizzappbasic

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "gameInfo")

data class gameInfo(@PrimaryKey (autoGenerate = true) val id:Int,
                    val isFinished:Boolean,
                    val isStarted:Boolean,
                    val puntosFinales:Int)
