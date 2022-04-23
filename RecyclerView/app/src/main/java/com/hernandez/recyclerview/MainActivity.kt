package com.hernandez.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hernandez.recyclerview.adapter.SuperHeroAdapter
import com.hernandez.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    Creacion del DataBiding
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }
//    inicializando el RecyclerView
private fun initRecyclerView(){

    /*
        val recyclerView = findViewById<RecyclerView>(R.id.recycleSuperhero)
        recyclerView.layoutManager = LinearLayoutManager(this)
Llamando al listado de todos los superheroes
        recyclerView.adapter = SuperHeroAdapter(SuperHeroDataBase.superHeroList)
        */
    binding.recycleSuperhero.layoutManager = LinearLayoutManager(this)
    binding.recycleSuperhero.adapter = SuperHeroAdapter(SuperHeroDataBase.superHeroList)


    }
}