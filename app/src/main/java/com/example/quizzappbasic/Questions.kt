package com.example.quizzappbasic

data class Question(val text: String, var answered:Boolean, var answeredCorrectly: Int, var correctAnswer: String, var incorrect1:String, var incorrect2:String, var incorrect3:String, var tema: String )