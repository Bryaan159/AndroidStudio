package com.hernandez.fragmentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Lo nuevo que se agrega
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

//        val fragment = GrettingFragment()

        val fragment = SumaFragment.newInstance(9,5)

        fragmentTransaction
            .add(R.id.frameLayout_fragment,fragment)
            .commit()




    }
}