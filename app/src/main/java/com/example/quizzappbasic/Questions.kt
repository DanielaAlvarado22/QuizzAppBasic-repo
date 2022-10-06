package com.example.quizzappbasic

data class Question(val text: String, var answered:Boolean, val correctAnswer: String, val incorrect1:String, val incorrect2:String, val incorrect3:String )