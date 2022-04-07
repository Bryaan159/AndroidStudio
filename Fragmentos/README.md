# FRAGMENTO

Pasos para agregar un fragment 

-Se debe de crear un Kotlin Class File  
-Se debe de colocar su nombre que deseamos "Name"  que en mi caso es GrettingFragment   
-Al entrar en "Name" : Fragment()  
-Se importa y la primera opcion   
-Se debe de agregar => override fun OnCreate()  
-Se debe de agregar un layout con Layout Resource File "LayoutName"

### Layout
-Se debe de agregar "LayoutName"
```xml
xmlns:tools="http://schemas.android.com/tools"
tools:context=".GrettingFragment"

```
-Ahora se debe de hacer el diseño que uno desea hacer aplicando ConstraitLayout
### GrettingFragment
```kotlin
    return inflater.inflate(R.layout."LayoutName",container,false)
```

### activity_main.xml
```xml
<!--    Fragmento estatico-->
<fragment
<!--    Se debe de colocar un id-->

    android:id="@+id/gretting_1"

<!--    Se debe de colocar el nombre pero recomendacion CTRL + SPACE para colocar el nombre-->

    android:name="com.hernandez.fragmentos.GrettingFragment"
  
<!--Para que no salga en gris y podamos visualizar el texto-->
    tools:layout="@layout/'LayoutName' "/>

```

Para agregarlo de manera manual se debe de usar un FrameLayout   
-Se debe de hacer de un tamaño el cuadro y luego regresarlo a wrap_content   
-Se debe de coloca un ID como tambien se le debe de agregar ConstraitLayout

```xml
<FrameLayout
        android:id="@+id/frameLayout_fragment"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="32dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.497"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/gretting_1" />
```
**Al reaalizar lo de FrameLayout se esta haciendo como un "<div></div>" diciendo donde quiero que se coloque dicho fragmento**


### MainAcivity
```kotlin
    val fragmentManager = supportFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()
    
//    Se debe de colocar el archivo secundario que se creo en .kt
    val fragment = GrettingFragment()

    fragmentTransaction
    .add(R.id.frameLayout_fragment,fragment)
    .commit()


```

### SumaFragment
```kotlin

//Agregar variables
private const val ARG_SUM1 = "sum1"
private const val ARG_SUM2 = "sum2"

class SumaFragment : Fragment() {
    // Se debe de colocar el tipo de variable que se va a utilizar
    private var sum1: Int? = null
    private var sum2: Int? = null

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

        sumando1TextView.text = sum1.toString()
        sumando2TextView.text = sum2.toString()

//    Para realizar la suma de ambos numeros
        resultTextView.text = sum1?.plus(sum2!!).toString()

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
//        Se debe de cambiar el tipo de variable si es String o Int para que se pueda hacer el buen uso de variable
        fun newInstance(sum1: Int, sum2: Int) =
            SumaFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SUM1, sum1)
                    putInt(ARG_SUM2, sum2)
                }
            }
    }
}
```

