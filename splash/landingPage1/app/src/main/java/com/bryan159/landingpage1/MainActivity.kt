package com.bryan159.landingpage1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Llamada de la funcion
        //Se debe de colocar la funcion que hemos creado en la linea 21


        startTimer()
    }

    //Nuevo
    fun startTimer(){
        //Se debe de hacer un object:CountDownTimer y luego object aparece en color rojo y darle ALT+ENTER
        //Y sobrescribir las funciones onTick y en OnFinish


        object:CountDownTimer(3000,1000){
            override fun onTick(p0: Long) {

            }
            override fun onFinish() {
                val intent = Intent(applicationContext,MainActivity2::class.java).apply{}
                    startActivity(intent)
            }

        }.start()
    }
}