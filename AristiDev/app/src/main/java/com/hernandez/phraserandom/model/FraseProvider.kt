package com.hernandez.phraserandom.model

class FraseProvider {
    companion object {


        //    Se debe de hacer un random debido a que como son frases aleatorias creamos una funcion
        fun fraseRandom(): FraseModel {
//        Queremos que sea random en el modelo hecho anteiormente en FraseModel.kt
            val random = (0..10).random()
            return quote[random]
        }


        //   En el listof<se debe de llamar al data> y dentro colocar los datos
        private val quote = listOf<FraseModel>(
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
}