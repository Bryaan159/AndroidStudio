package com.hernandez.phraserandom.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.hernandez.phraserandom.databinding.ActivityMainBinding
import com.hernandez.phraserandom.model.FraseModel
import com.hernandez.phraserandom.viewModel.FraseViewModel

class MainActivity : AppCompatActivity() {
//    Aprenderse de memoria Binding
    private lateinit var binding:ActivityMainBinding

    //        llamar al ViewModel
    private val fraseViewModel: FraseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Binding llamarla aqui
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Enlanzar el id del text de la frase y del text autor con el ViewModel
//        Para cambiar el it:FraseModel! se usa un arrow y antes se pone el nombre
        fraseViewModel.fraseModel.observe(this, Observer { actualFrase ->
            binding.tvQuote.text = actualFrase.quote
            binding.tvAuthor.text = actualFrase.author

        })

//        Para que cuando se le de clic a la pantalla de una frase random
        binding.viewContainer.setOnClickListener{fraseViewModel.randomFrase()}
    }
}