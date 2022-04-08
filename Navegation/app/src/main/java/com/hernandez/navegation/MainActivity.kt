package com.hernandez.navegation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.hernandez.navegation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


// Creando el DataBinding
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        Llamando la variable creado por el databinding
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val navHostFragment = binding.navHostFragment as NavHostFragment
        val navController = navHostFragment.navController



        binding.actionChange.setOnClickListener{

            navController.navigate(R.id.action_homeFragment_to_secondFragment)


        }
    }
}