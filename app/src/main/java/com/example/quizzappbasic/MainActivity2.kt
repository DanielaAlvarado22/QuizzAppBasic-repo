package com.example.quizzappbasic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    lateinit var checkBox: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val chk = findViewById<CheckBox>(R.id.checkbox1)
        val chk2 = findViewById<CheckBox>(R.id.checkbox2)
        val chk3 = findViewById<CheckBox>(R.id.checkbox3)
        val chk4 = findViewById<CheckBox>(R.id.checkbox4)
        val btnVer = findViewById<Button>(R.id.btnVer)

        btnVer.setOnClickListener (View.OnClickListener{
            if (chk.isChecked){
                Toast.makeText(this,"CHOCHA!!",Toast.LENGTH_SHORT).show()
                chk2.isEnabled = false
                chk3.isEnabled = false
                chk4.isEnabled = false
            }
            if (chk2.isChecked){
                Toast.makeText(this,"CULO!!",Toast.LENGTH_SHORT).show()
                chk.isEnabled = false
                chk3.isEnabled = false
                chk4.isEnabled = false
            }
            if (chk3.isChecked){
                Toast.makeText(this,"TETA!!",Toast.LENGTH_SHORT).show()
                chk.isEnabled = false
                chk2.isEnabled = false
                chk4.isEnabled = false
            }
            if (chk4.isChecked){
                Toast.makeText(this,"LA COMBI COMPLETA!!",Toast.LENGTH_SHORT).show()
                chk.isEnabled = false
                chk2.isEnabled = false
                chk3.isEnabled = false
            }
        }
        )



        val btnRegresar = findViewById<Button>(R.id.btnRegresar)
        btnRegresar.setOnClickListener {
            val lanzar = Intent(this,MainActivity::class.java)
            startActivity(lanzar)
        }
    }
}