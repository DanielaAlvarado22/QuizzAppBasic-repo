package com.example.quizzappbasic

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface gameInfoDao {

    @Query("INSERT INTO gameInfo(isFinished,isStarted,puntosFinales,player) values (:terminado,:iniciado,:puntosFinales,:player)" )
    fun AddGameInfo(terminado:Boolean,iniciado:Boolean,puntosFinales:Int,player:String)

    @Query("SELECT * FROM gameInfo ORDER BY id DESC LIMIT 1" )
    fun getLastGameId(): gameInfo

    @Query("INSERT INTO gameConfiguracion (id,idConfig) values (:id,:idConfig)")
    fun AddGameConfig(id:Int,idConfig:Int)





}