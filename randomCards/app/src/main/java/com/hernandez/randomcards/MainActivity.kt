package com.hernandez.randomcards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.util.*
import kotlin.random.Random


/*
Explicacion del codigo
- Creacion de las variables para llamar a las cards y el boton : lateint var Name :type
- Creacion de un array para las tarjetas que se van a utilizar val Name: IntArray = intArrayOf(
    R.drawable.namecard
)
- Llamar a las primeras variables creadas y buscarlas con su id respectivo.
- Realizar una funcion de clickOnListener para que haga algo al darle click
- Hacer una funcion random val name = Random
    NameView.setImageResources(NameArray[nameRandom.nextInt(NameArray.size)])
 */

class MainActivity : AppCompatActivity() {

    lateinit var imageView:ImageView
    lateinit var buttonRandom:Button

    val barajaCards: IntArray = intArrayOf(
        R.drawable.hearts2,
        R.drawable.hearts3,
        R.drawable.hearts4,
        R.drawable.hearts5,
        R.drawable.hearts6,
        R.drawable.hearts7,
        R.drawable.hearts8,
        R.drawable.hearts9,
        R.drawable.hearts10,
        R.drawable.hearts12,
        R.drawable.hearts13,
        R.drawable.hearts14,
        R.drawable.hearts15
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()

        buttonRandom.setOnClickListener{
            randomCards()
        }
    }

    private fun bind(){
        imageView = findViewById(R.id.imageView)
        buttonRandom = findViewById(R.id.boton)

    }
    private fun randomCards(){
        val randomCard = Random
        imageView.setImageResource(barajaCards[randomCard.nextInt(barajaCards.size)])
    }
}