package com.hernandez.darkmode

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode

private lateinit var action_switch_btn:Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Creacion de variables a utilizar
        action_switch_btn = findViewById(R.id.switch_btn)
//        Configuracion de preferencia
        val appSettingPrefs: SharedPreferences = getSharedPreferences("appSettingPrefs",0)

//        Preferencias compartidas Editar
        val sharedPrefsEdit:SharedPreferences.Editor = appSettingPrefs.edit()

//      Primer booleano
        val isNightModeOn:Boolean = appSettingPrefs.getBoolean("NightMode",false)

//        Condicionales
        if(isNightModeOn){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            action_switch_btn.text = getString(R.string.disable_dark)
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            action_switch_btn.text = getString(R.string.text_btn_view)
        }


// Darle vida al botn de Enable Dark
        action_switch_btn.setOnClickListener({
            if(isNightModeOn){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                action_switch_btn.text = getString(R.string.text_btn_view)
                sharedPrefsEdit.putBoolean("NightMode",false)
                sharedPrefsEdit.apply()

            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                action_switch_btn.text = getString(R.string.disable_dark)
                sharedPrefsEdit.putBoolean("NightMode",true)
                sharedPrefsEdit.apply()
            }
        })


    }
}