package com.example.quizzappbasic

import android.widget.CheckBox
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Config(@PrimaryKey (autoGenerate = true) val id:Int,
                  val checkBox:Boolean,
                  val checkBox2: Boolean,
                  val checkBox3: Boolean,
                  val checkBox4: Boolean,
                  val checkBox5: Boolean,
                  val checkBox6: Boolean,
                  val pistas:Boolean,
                  val spinn:Int,
                  val cantPreguntas:Int)
