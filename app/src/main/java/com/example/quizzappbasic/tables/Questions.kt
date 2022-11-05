package com.example.quizzappbasic

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "questions")

data class Question(@PrimaryKey val questionId:Int,
                    val text: String,
                    var answered:Boolean,
                    var answeredCorrectly: Int,
                    var correctAnswer: String,
                    var incorrect1:String,
                    var incorrect2:String,
                    var incorrect3:String,
                    var tema: String,
                    var usoHint:Boolean )