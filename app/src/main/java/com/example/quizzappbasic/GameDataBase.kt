package com.example.quizzappbasic

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Question::class,Config::class,gameInfo::class], version = 1)
abstract class GameDataBase: RoomDatabase() {

    abstract fun questionsDao(): QuestionsDao
    abstract fun configDao(): ConfigDao
    abstract fun GameInfoDao(): gameInfoDao

}