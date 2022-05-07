# PhraseRandomLol

### build.gradle(:app)
```kotlin
android{
    buildFeatures{
        viewBinding = true
    }
}
```

```kotlin
dependecies {
    // Fragment
    implementation "androidx.fragment:fragment-ktx:1.3.2"
    // Activity
    implementation "androidx.activity:activity-ktx:1.2.2"
    // ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1"
    // LiveData
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.3.1"
}
```

### activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/viewContainer"
    android:background="@drawable/fondo"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

<!--    Phrase-->
    <TextView
        android:id="@+id/tvQuote"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        tools:text="Hello World!"
        android:gravity="center"
        android:padding="16dp"
        android:textColor="@color/white"
        android:textSize="24sp"
        android:textStyle="italic"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

<!--    Author-->
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/idAuthor"
        tools:text="Hello World!"
        android:gravity="center"
        android:padding="16dp"
        android:textColor="@color/white"
        android:textSize="24sp"
        android:textStyle="italic"
        tools:ignore="MissingConstraints"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```

#### Creacion del Binding
Se tiene que hacer el documento de MainActivity.kt
```kotlin
class MainActivity : AppCompatActivity() {
//    Aprenderse de memoria Binding
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        Binding llamarla aqui
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
```
#### QuoteModel
Se debera de hacer un package con nombre model y dentro una clase "QuoteModel"  

Donde se va almacenar los paremetros que nos piden para los datos
```kotlin
data class FraseModel (val quote:String,val author:String)
```

#### QuoteProvider
Se debe de hacer las frases quemadas de cada personaje con su frase o con base a los parametros hechos en QuoteModel
```kotlin
class QuoteProvider {


    //    Se debe de hacer un random debido a que como son frases aleatorias creamos una funcion
    fun random(): FraseModel {
//        Queremos que sea random en el modelo hecho anteiormente en QuoteModel.kt
        val random = (0..10).random()
        return quote[random]
    }


    //   En el listof<se debe de llamar al data> y dentro colocar los datos
    val quote = listOf<FraseModel>(
        FraseModel(
            quote = "A nadie se le ha prometido el mañana.",
            author = "Yasuo"
        ), FraseModel(
            quote = "La fortuna no sonríe a los necios.",
            author = "Miss Fortune"

        ), FraseModel(
            quote = "Dejemos de hablar de Draven. Ahora hablemos de Draven",
            author = "Draven"
        ), FraseModel(
            quote = "¡Todo es risas y diversión, hasta que a alguien le parten la carota!",
            author = "Sett"
        ), FraseModel(
            quote = "Mi profesión!? Ah... ahora que lo pienso, me hubiera encantado ser panadero... sí... panadero.",
            author = "Pantheon"
        ), FraseModel(
            quote = "Nombra un solo genio que no está loco.",
            author = "Rakan"
        ),
        FraseModel(
            quote = "Se necesita un monstruo para matar a otro.",
            author = "Warwick"
        ), FraseModel(
            quote = "Un corazón frío necesita una sonrisa calurosa.",
            author = "Braum"
        ), FraseModel(
            quote = "El tiempo va curando todas las heridas, pero algunas las escondemos nosotros mismos",
            author = "Ekko"
        ), FraseModel(
            quote = "¿Crees que estoy loca? Pues deberías conocer a mi hermana.",
            author = "Jinx"
        ), FraseModel(
            quote = "uno dos tres cuatro",
            author = "Jhin"
        ), FraseModel(
            quote = "Si no cambiamos, algo se duerme en nuestro interior y rara vez despierta.",
            author = "Illaoi"
        ), FraseModel(
            quote = "Es una pena. Tengo dos puños pero tú sólo tienes una cara.",
            author = "Vi"
        ),
        FraseModel(
            quote = "Me ama, no me ama. Me ama, no me ama. ¡Me ama!",
            author = "Morgana"
        )

    )
}
```
### FraseViewModel
Se debe de implementar el ViewModel para tener todas las capas
```kotlin
class FraseViewModel: ViewModel() {

//    Tenemos que encapsular los datos manteniendolos en un LiveData pero con el modelo <FraseModel>
    val fraseModel = MutableLiveData<FraseModel>()

//    Realizar una funcion para que nos de una frase random con base a la posicion random que se hizo en FraseProvider
    fun randomFrase(){
        val actualFrase:FraseModel = FraseProvider.fraseRandom()
        fraseModel.postValue(actualFrase)
    }

}
```

### MainActivity.kt
Se debe de modificar para que ahora se presente en pantalla
```kotlin
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
            binding.tvQuote.text = actualFrase.author
            binding.tvAuthor.text = actualFrase.quote

        })

//        Para que cuando se le de clic a la pantalla de una frase random
        binding.viewContainer.setOnClickListener{fraseViewModel.randomFrase()}
    }
}
```

