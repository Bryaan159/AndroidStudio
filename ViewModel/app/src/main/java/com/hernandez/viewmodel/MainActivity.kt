package com.hernandez.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

//    Delegacion para llamar a ViewModel
//    Aqui estamos llamando al archivo
    private val viewModel:MainViewModel by viewModels()

//    Declarar las variables a utilizar
    private lateinit var searchEditText:EditText
    private lateinit var buttonSearch:Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()

        addListerners()

//        Nuevo para mi
        searchEditText.setText(viewModel.query)
        resultTextView.text = viewModel.result


    }

    private fun addListerners() {
        buttonSearch.setOnClickListener{
            val query = searchEditText.text.toString()
            resultTextView.text=viewModel.onSearch(query)

        }
    }

    private fun bind(){
        buttonSearch = findViewById(R.id.action_search)

//        Totalmente nuevo debido a que necesitamos el EditLayout
        val searchInputLayout:TextInputLayout = findViewById(R.id.query_edit_text)
//        !! =>
        searchEditText = searchInputLayout.editText!!
        resultTextView = findViewById(R.id.result_text_view)
    }
}




