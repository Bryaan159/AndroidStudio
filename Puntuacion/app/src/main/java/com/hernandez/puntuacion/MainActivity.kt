package com.hernandez.puntuacion

import android.content.Intent
import android.nfc.Tag
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
    private  lateinit var saveButton:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"onCreate")
        bind()
//      Utilizar condicionales almacenar los datos
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

        //Save
        saveButton = findViewById(R.id.action_save)

    }


//    Almacenar los datos cuando se voltea la pantalla y queremos almacenar los datos
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_SCORE_TEAM_A,scoreTeamA)
        outState.putInt(KEY_SCORE_TEAM_B,scoreTeamB)
        Log.d(TAG,"onSaveInstance")

    }


    private  fun addListeners(){
//    Aqui esta la clave de la tarea
        teamAddButton.setOnClickListener{
            scoreTeamA=scoreTeamA+1
            updateVisualScore(teamAScoreTextView,scoreTeamA)
        }
        teamBAddButton.setOnClickListener{
            scoreTeamB++
            updateVisualScore(teamBScoreTextView,scoreTeamB)
        }

        saveButton.setOnClickListener{
            onSave()
        }
    }

    private fun onSave(){
        Log.d(TAG,"onSave")

        //Intent
        //Yo quiero ir desde esta pagina hasta la otra
        val intent = Intent(this,ScoreActivity::class.java)

//      Poder utilizar los valores del score
        intent.putExtra(KEY_SCORE_TEAM_A,scoreTeamA)
        intent.putExtra(KEY_SCORE_TEAM_B,scoreTeamB)

        startActivity(intent)
    }


//    esta realizando una funcion con argumentos
    private fun updateVisualScore(view:TextView,score:Int){
        view.text = score.toString()
    }

    private  fun setupScores(){
//        Colocar siempre en toString() debido a que se tiene que tener en modo texto
        updateVisualScore(teamAScoreTextView,scoreTeamA)
        updateVisualScore(teamBScoreTextView,scoreTeamB)
    }



//    =============================================================================================

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
        val TAG = MainActivity::class.simpleName


//        Declarar una constante para evitar errores de mano
        const val KEY_SCORE_TEAM_A = "ScoreTeamA"
        const val KEY_SCORE_TEAM_B = "ScoreTeamB"
    }

}