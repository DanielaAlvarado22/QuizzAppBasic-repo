package com.example.quizzappbasic

import android.widget.CheckBox
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Config(@PrimaryKey (autoGenerate = true) val id:Int,
                  val checkBox:CheckBox,
                  val checkBox2: CheckBox,
                  val checkBox3: CheckBox,
                  val checkBox4: CheckBox,
                  val checkBox5: CheckBox,
                  val checkBox6: CheckBox,
                  val pistas:Boolean,
                  val spinn:Int,
                  val cantPreguntas:Int)
