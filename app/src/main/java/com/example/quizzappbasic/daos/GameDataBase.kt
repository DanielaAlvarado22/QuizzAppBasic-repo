package com.example.quizzappbasic.daos

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.quizzappbasic.Question
import com.example.quizzappbasic.tables.gameConfig
import com.example.quizzappbasic.tables.Config
import com.example.quizzappbasic.tables.QuestionTemasRef
import com.example.quizzappbasic.tables.gameInfo

@Database(entities = [Question::class, Config::class, gameInfo::class, QuestionTemasRef::class, gameConfig::class], version = 1)
abstract class GameDataBase: RoomDatabase() {

    abstract fun questionsDao(): QuestionsDao
    abstract fun configDao(): ConfigDao
    abstract fun GameInfoDao(): gameInfoDao


}