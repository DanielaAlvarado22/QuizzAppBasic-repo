package com.example.quizzappbasic

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface gameInfoDao {

    @Query("INSERT INTO gameInfo(isFinished,isStarted,puntosFinales) values (:terminado,:iniciado,:puntosFinales)" )
    fun AddGameInfo(terminado:Boolean,iniciado:Boolean,puntosFinales:Int)

}