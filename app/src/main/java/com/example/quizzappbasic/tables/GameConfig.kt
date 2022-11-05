package com.example.quizzappbasic.tables

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity (tableName = "gameConfiguracion")
data class gameConfig(@PrimaryKey val id:Int, val idConfig: Int)
