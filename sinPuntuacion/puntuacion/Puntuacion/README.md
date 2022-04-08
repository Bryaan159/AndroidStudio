# Puntuacion sin score de ganador

### Activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:orientation="vertical"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <!--  Primer LinearLayout-->
    <!--    Peso para dividir la pantalla-->
     <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="0dp"

        android:layout_weight="1"
        android:orientation="vertical"
        android:gravity="center">
        
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textAppearance="@style/TextAppearance.MaterialComponents.Headline6"
            android:text="@string/head_team_a" />

        <TextView
            android:id="@+id/score_team_a_text_view"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textAppearance="@style/TextAppearance.MaterialComponents.Headline1"
            android:layout_marginTop="@dimen/small_gap"
            tools:text="0"/>
        <Button
            android:id="@+id/add_one_team_a"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/action_add_gol"
            android:layout_marginTop="@dimen/default_gap"/>

    </LinearLayout>


    <!--    Segundo LinearLayout-->
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:orientation="vertical"
        android:gravity="center">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textAppearance="@style/TextAppearance.MaterialComponents.Headline6"
            android:text="@string/head_team_b" />

        <TextView
            android:id="@+id/score_team_b_text_view"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textAppearance="@style/TextAppearance.MaterialComponents.Headline1"
            tools:text="0"
            android:layout_marginTop="@dimen/small_gap"/>
        <Button
            android:id="@+id/add_one_team_b"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/action_add_gol"
            android:layout_marginTop="@dimen/default_gap"/>

    </LinearLayout>


</LinearLayout>
```
### MainActivity.kt

#### TAG
```kotlin
 val TAG = MainActivity::class.simpleName
```
#### savedInstanceState
```kotlin
savedInstanceState?.let{ bundle ->
            scoreTeamA = bundle.getInt(KEY_SCORE_TEAM_A,0)
            scoreTeamB = bundle.getInt(KEY_SCORE_TEAM_B,0)

        }
```

### MainActivity.kt
```kotlin
package com.hernandez.puntuacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //    Views de las anotaciones "Datos"
    private var scoreTeamA = 0
    private var scoreTeamB = 0

    //    Atributos generales
    private lateinit var teamAScoreTextView: TextView
    private lateinit var teamBScoreTextView: TextView
    private lateinit var teamAddButton:Button
    private lateinit var teamBAddButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"onCreate")
        bind()
//      Utilizar condicionales
//       Para almacenar la informacion y no se pierda al salir de la app
        savedInstanceState?.let{ bundle ->
            scoreTeamA = bundle.getInt(KEY_SCORE_TEAM_A,0)
            scoreTeamB = bundle.getInt(KEY_SCORE_TEAM_B,0)

        }

        setupScores()
        addListeners()

    }
    private fun bind(){
//        Team A
        teamAScoreTextView = findViewById(R.id.score_team_a_text_view)
        teamAddButton = findViewById(R.id.add_one_team_a)

//        Team B
        teamBScoreTextView = findViewById(R.id.score_team_b_text_view)
        teamBAddButton = findViewById(R.id.add_one_team_b)
    }


    //    Almacenar los datos cuando se voltea la pantalla y queremos almacenar los datos
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_SCORE_TEAM_A,scoreTeamA)
        outState.putInt(KEY_SCORE_TEAM_B,scoreTeamB)
        Log.d(TAG,"onSaveInstance")

    }

    //  Contador para que aumenta en la app
    private  fun addListeners(){
//    Aqui esta la clave de la tarea
        teamAddButton.setOnClickListener{
            scoreTeamA++
            updateVisualScore(teamAScoreTextView,scoreTeamA)
        }
        teamBAddButton.setOnClickListener{
            scoreTeamB++
//            Para que el nuevo cambio se vea desde la pantalla
            updateVisualScore(teamBScoreTextView,scoreTeamB)
        }
    }
    //    esta realizando una funcion con argumentos
    private fun updateVisualScore(view:TextView,score:Int){
//      Se le llama al TextView y se le asigna el valor del contador pero se pasa a texto
        view.text = score.toString()
    }

    private  fun setupScores(){
//        Colocar siempre en toString() debido a que se tiene que tener en modo texto
        updateVisualScore(teamAScoreTextView,scoreTeamA)
        updateVisualScore(teamBScoreTextView,scoreTeamB)
    }



    //    =============================================================================================
//    Ciclo de vida de un programa
    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"onRestart")
    }

    companion object{
        //        Se declara Tag para que aparezca toda la actividad en Main
        val TAG = MainActivity::class.simpleName

        //        Declarar una constante para evitar errores de mano
        private const val KEY_SCORE_TEAM_A = "scoreTeamA"
        private const val KEY_SCORE_TEAM_B = "scoreTeamB"
    }
}
```