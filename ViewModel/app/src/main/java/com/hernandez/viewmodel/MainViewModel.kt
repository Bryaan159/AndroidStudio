package com.hernandez.viewmodel

import androidx.lifecycle.ViewModel
import java.time.temporal.TemporalQuery

class MainViewModel:ViewModel() {

//    Data
    var query = ""
    var result = ""

    fun onSearch(query:String):String{
//        Nuevas cosas por aprender
        this.query = query
        result = "El resultado de $query es este"
        return result
    }
}