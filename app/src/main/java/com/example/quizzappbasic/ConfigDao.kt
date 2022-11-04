package com.example.quizzappbasic

import androidx.room.*


@Dao
interface ConfigDao {

    @Query("SELECT * FROM configuracion WHERE id = :id")
    fun GetConfig(id:Int): Config

//    @Insert
//    fun AddConfig(configuracion: Config)

    @Query("SELECT * FROM configuracion ORDER BY id DESC LIMIT 1")
    fun GetLastConfig() : Config

    @Query("INSERT INTO configuracion(checkBox,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,pistas,spinn,cantPreguntas) values(:entretenimiento,:historia,:animales, :cultura, :videojuegos, :todos, :pistas,:spinn,:cantPreguntas)")
    fun AddConfig(entretenimiento:Boolean,historia:Boolean,animales:Boolean,cultura:Boolean,videojuegos:Boolean,todos:Boolean,pistas:Boolean,spinn:Int,cantPreguntas:Int)

    @Update
    fun UpdateConfig(configuracion: Config)

    @Delete
    fun DaleteConfig(configuracion: Config)

}