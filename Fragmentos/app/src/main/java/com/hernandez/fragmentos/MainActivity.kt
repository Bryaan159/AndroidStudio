package com.hernandez.fragmentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity(), SumaFragment.onActionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Lo nuevo que se agrega
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

//        val fragment = GrettingFragment()

        val fragment = SumaFragment.newInstance(2,2)

        fragmentTransaction
            .add(R.id.frameLayout_fragment,fragment)
            .commit()

    }

    override fun onActionClick(result: Int) {
        Toast
            .makeText(this,"El resultado es $result",Toast.LENGTH_SHORT)
            .show()
    }
}