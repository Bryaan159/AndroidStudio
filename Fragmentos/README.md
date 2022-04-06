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
*** Al reaalizar lo de FrameLayout se esta haciendo como un <div></div> diciendo donde quiero que se coloque dicho fragmento   


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

