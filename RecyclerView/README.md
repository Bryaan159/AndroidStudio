### ReciclerView

Explicacion de cada paso para lograr el reciclerView

##### activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">
    
<!--    Se le debe de color un id porque este ReclyclerView es el que se va a utilizar-->
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recycleSuperhero"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

</FrameLayout>
```

##### SuperHero.kt
Se debe de hacer una clase de tipo data donde se guardara cada uno de los parametros que va a llevar nuestra lista
```kotlin
data class SuperHero(
    val superhero: String,
    val publisher: String,
    val realName: String,
    val photo: String
)
```

##### SuperHeroDataBase.kt
Se debe de colocar la informacion de nuestro personaje en base a las parametros que se
definieron en SuperHero.kt
```kotlin
class SuperHeroDataBase {
    companion object {
        val superHeroList = listOf<SuperHero>(
            SuperHero(
                "Bryaan159",
                "Develoment",
                "Bryan Hernandez",
                "https://i.pinimg.com/474x/87/09/b7/8709b745f5e8d9aa5e8270780e21117b.jpg"
            ),
            SuperHero(
                "Iron Man",
                "Marvel",
                "Tony Stark",
                "https://www.sideshow.com/storage/product-images/3003532/iron-man-mark-xliii_marvel_square.jpg"
            ),
            SuperHero(
                "Thor",
                "Marvel",
                "Thor Odinson",
                "https://terrigen-cdn-dev.marvel.com/content/prod/1x/004tho_ons_mas_mob_01_0.jpg"
            ),
            SuperHero(
                "Batman",
                "DC",
                "Bruce Wayne",
                "https://preview.redd.it/ajcve4pklyt71.jpg?auto=webp&s=b7717972a8a1e6b21f2b95e6d41acc57000112cb"
            ),
            SuperHero(
                "Shazam",
                "Dc",
                "Billy Batson",
                "https://assets.mycast.io/posters/shazam-fan-casting-poster-26769-large.jpg?1580443266"
            ),
            SuperHero(
                "Moon Knight",
                "Marvel",
                "Marc Spector",
                "https://www.disneyplusinformer.com/wp-content/uploads/2022/03/Moon-Knight-Profile-Avatar.png"
            ),
            SuperHero(
                "Peacemaker",
                "Dc",
                "Christopher Smith",
                "https://pbs.twimg.com/media/E9ai1b-WYAICrgA.jpg"
            )
        )
    }
}
```

##### item_superhero.xml
Se debe de establecer el diseño que se va a utilizar con <textView>, <ImageView>
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <ImageView
        android:id="@+id/ivSuperHero"
        android:layout_width="150dp"
        android:layout_height="150dp"
        tools:background="@color/black"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/tvSuperHeroName"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toEndOf="@+id/ivSuperHero"
        tools:text="HolaName" />
    <TextView
        android:id="@+id/tvRealName"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintStart_toEndOf="@+id/ivSuperHero"
        app:layout_constraintTop_toBottomOf="@+id/tvSuperHeroName"
        tools:text="HolaRealName" />
    <TextView
        android:id="@+id/tvPublisher"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toBottomOf="@+id/tvRealName"
        app:layout_constraintStart_toEndOf="@+id/ivSuperHero"
        tools:text="HolaPublisher" />
    
</androidx.constraintlayout.widget.ConstraintLayout>
```
