package com.hernandez.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hernandez.recyclerview.adapter.SuperHeroAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }
//    inicializando el RecyclerView
private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recycleSuperhero)
        recyclerView.layoutManager = LinearLayoutManager(this)
//    Llamando al listado de todos los superheroes
        recyclerView.adapter = SuperHeroAdapter(SuperHeroDataBase.superHeroList)
    }
}