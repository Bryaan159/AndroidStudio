package com.hernandez.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hernandez.recyclerview.R
import com.hernandez.recyclerview.SuperHero

class SuperHeroAdapter(private val superheroList: List<SuperHero>) : RecyclerView.Adapter<SuperHeroViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {

//        Redenrizar lo que se vea en la app
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_superhero,parent,false))
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
//  Uniendo al ViewHolder para poder utilizar las variables declaradas en SuperHeroViewHolder.kt
        val item = superheroList[position]
        holder.reder(item)
    }

//    Probar colocando un numero quemado
    override fun getItemCount(): Int = superheroList.size


}