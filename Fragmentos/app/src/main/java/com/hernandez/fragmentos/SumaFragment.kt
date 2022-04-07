package com.hernandez.fragmentos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import java.lang.ClassCastException


//Agregar variables
private const val ARG_SUM1 = "sum1"
private const val ARG_SUM2 = "sum2"

class SumaFragment : Fragment() {
    // Se debe de colocar el tipo de variable que se va a utilizar
    private var sum1: Int? = null
    private var sum2: Int? = null

//    Interfaces
    private var listerner: onActionListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listerner = context as? onActionListener
        if(listerner == null){
            throw ClassCastException("$context must implement onActionListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
//            El get debe de ir con base al tipo de variable es:
            sum1 = it.getInt(ARG_SUM1,0)
            sum2 = it.getInt(ARG_SUM2,0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_suma, container, false)
    }

// Se debe de crear una nueva funcion para que se pueda utilizar los argumentos
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//    Crear las nuevas variables para utilziar en nuestro programa
        val sumando1TextView:TextView = view.findViewById(R.id.sumando_uno_text_view)
        val sumando2TextView:TextView = view.findViewById(R.id.sumando_dos_text_view)
        val resultTextView:TextView = view.findViewById(R.id.resultado_text_view)

//    Interface
        val result:Int =(sum1?.plus(sum2!!))?:0

        sumando1TextView.text = sum1.toString()
        sumando2TextView.text = sum2.toString()

//    Para realizar la suma de ambos numeros
        resultTextView.text = result.toString()

//    Buscar el boton
    val actionButton:Button = view.findViewById(R.id.action_button)
    actionButton.setOnClickListener{
        listerner?.onActionClick(result)
    }

    }

//    Interface
    interface  onActionListener{
        fun onActionClick(result:Int)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param sum1 Parameter 1.
         * @param sum2 Parameter 2.
         * @return A new instance of fragment SumaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(sum1: Int, sum2: Int) =
            SumaFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SUM1, sum1)
                    putInt(ARG_SUM2, sum2)
                }
            }
    }
}