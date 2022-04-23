package com.hernandez.recyclerview.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hernandez.recyclerview.R
import com.hernandez.recyclerview.SuperHero

class SuperHeroViewHolder(view: View):RecyclerView.ViewHolder(view){

//    Crear cada variable de los de item_superhero
    val superHero = view.findViewById<TextView>(R.id.tvSuperHeroName)
    val realName = view.findViewById<TextView>(R.id.tvRealName)
    val publisher = view.findViewById<TextView>(R.id.tvPublisher)
    val photo = view.findViewById<ImageView>(R.id.ivSuperHero)


//    Llamando cada variable y igualandolo con el argumento SuperHeroModel
    fun reder(superHeroModel: SuperHero){
        superHero.text = superHeroModel.superhero
        realName.text = superHeroModel.realName
        publisher.text = superHeroModel.publisher

    }
}