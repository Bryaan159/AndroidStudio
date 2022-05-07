package com.hernandez.phraserandom.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hernandez.phraserandom.model.FraseModel
import com.hernandez.phraserandom.model.FraseProvider

class FraseViewModel: ViewModel() {

//    Tenemos que encapsular los datos manteniendolos en un LiveData pero con el modelo <FraseModel>
    val fraseModel = MutableLiveData<FraseModel>()

//    Realizar una funcion para que nos de una frase random con base a la posicion random que se hizo en FraseProvider
    fun randomFrase(){
        val actualFrase:FraseModel = FraseProvider.fraseRandom()
        fraseModel.postValue(actualFrase)
    }

}