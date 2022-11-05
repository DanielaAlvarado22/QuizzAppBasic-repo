package com.example.quizzappbasic.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.example.quizzappbasic.tables.gameInfo

@Dao
interface gameInfoDao {

    @Query("INSERT INTO gameInfo(isFinished,isStarted,puntosFinales,player) values (:terminado,:iniciado,:puntosFinales,:player)" )
    fun AddGameInfo(terminado:Boolean,iniciado:Boolean,puntosFinales:Int,player:String)

    @Query("SELECT * FROM gameInfo ORDER BY gameId DESC LIMIT 1" )
    fun getLastGame(): gameInfo

    @Query("INSERT INTO gameConfiguracion (id,idConfig) values (:id,:idConfig)")
    fun AddGameConfig(id:Int,idConfig:Int)

    @Update()
    fun UpdateGame(game: gameInfo)

    @Query("SELECT puntosFinales FROM gameInfo ORDER BY puntosFinales DESC LIMIT 5")
    fun getTop5PuntajesFinales(): List<Int>

    @Query("SELECT puntosFinales FROM gameInfo WHERE gameId =:gameid")
    fun getPuntajeActual(gameid:Int): Int

    @Query("SELECT puntosFinales FROM gameInfo ORDER BY puntosFinales DESC")
    fun getTodosPuntajes(): List<Int>




}