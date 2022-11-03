package com.example.quizzappbasic

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class gameInfo(@PrimaryKey val id:Int,
                    val isFinished:Boolean,
                    val isStarted:Boolean,
                    val puntosFinales:Int)
