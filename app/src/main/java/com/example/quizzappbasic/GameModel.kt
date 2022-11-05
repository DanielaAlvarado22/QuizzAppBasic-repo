package com.example.quizzappbasic

import android.telephony.mbms.MbmsErrors
import androidx.lifecycle.ViewModel
import java.lang.Math.random

class GameModel : ViewModel() {

    private val questions = mutableListOf<Question>()
    private var currentQuestionIndex = 0
    private var puntaje = 0
    private var hintsTotal = 5
    private var HintsConsecutiva = 0
    private var contAnswered = 0
    private var PuntosMenosHints = 0


    init {
        questions.add(Question(1,"¿Cual ha sido la pelicula más taquillera de la historia?",false,0,"Avengers:Endgame","Titanic","Avatar","Spiderman:No Way Home","Entretenimiento",false))
        questions.add(Question(2,"¿Cual fue la primera pelicula de Walt Disney",false,0,"Blancanieves","La cenicienta","La sirenita","Frozen","Entretenimiento",false))
        questions.add(Question(3,"¿Que pelicula NO es de Pixar?",false,0,"Hercules","Toy Story","Cars","Soul","Entretenimiento",false))
        questions.add(Question(4,"¿Cuantos premios Oscars gano la pelicula Titanic? ",false,0,"11","5","9","7","Entretenimiento",false))
        questions.add(Question(5,"¿En que año se estreno la pelicula Matrix?",false,0,"1999","2000","1997","2001","Entretenimiento",false))
        questions.add(Question(6,"¿De que color es el pelaje de un oso polar?",false,0,"Transparente","Blanco","Marron","Negro","Animales",false))
        questions.add(Question(7,"¿Cuantos corazones tiene un pulpo?",false,0,"3","2","1","No tiene","Animales",false))
        questions.add(Question(8,"¿Qué animal tiene los dientes más grandes?",false,0,"Narval","Morsa","Elefante","Castor","Animales",false))
        questions.add(Question(9,"¿Cuantos parpados tienen los camellos en cada ojo?",false,0,"3","2","No tienen","4","Animales",false))
        questions.add(Question(10,"¿Cual es el animal más grande del mundo?",false,0,"Ballena Azul","Tiburon Ballena","Orca","Calamar gigante","Animales",false))
        questions.add(Question(11,"¿Cual es el océano más grande del mundo?",false,0,"Pácifo","Atlántico","Índico","Antártico","Cultura general",false))
        questions.add(Question(12,"¿Cual es el país más pequeño del mundo?",false,0,"El Vaticano","Grenada","Monaco","Barbados","Cultura general",false))
        questions.add(Question(13,"¿Cuantos huesos tiene el cuerpo humano?",false,0,"206","200","157","189","Cultura general",false))
        questions.add(Question(14,"¿Cuantos años tiene un lustro?",false,0,"5","10","15","50","Cultura general",false))
        questions.add(Question(15,"Cual es el país del sol naciente?",false,0,"Japón","México","Colombia","Argentina","Cultura general",false))
        questions.add(Question(16,"¿Quien fue el primer presidente de México?",false,0,"Guadalupe Victoria","Miguel Hidalgo","Vicente Guerrero","José María Morelos","Historia de México",false))
        questions.add(Question(17,"¿A qué cultura pertenecen las cabezas colosales?",false,0,"Olmeca","Maya","Mexica","Nahuatls","Historia de México",false))
        questions.add(Question(18,"¿Que se celebra el 5 de mayo?",false,0,"Batalla de Puebla","La independencia","Guerra de los pasteles","Nada","Historia de México",false))
        questions.add(Question(19,"¿En que año inicio la Revolución Mexicana?",false,0,"1910","1810","1921","1917","Historia de México",false))
        questions.add(Question(20,"¿En que año fue la promulgación de la Constitución?",false,0,"1917","1821","1920","1810","Historia de México",false))
        questions.add(Question(21,"¿En que año salio la Nintendo 64?",false,0,"1996","1964","2000","1999","Videojuegos",false))
        questions.add(Question(22,"¿En que planeta vive Kirby?",false,0,"Pop Star","Planet Robot","Dreamland","Pinball Land","Videojuegos",false))
        questions.add(Question(23,"¿Cual es el videojuego más vendido en la historia?",false,0,"Wii Sports","Minecraft","Super Mario Bros","Mario Kart","Videojuegos",false))
        questions.add(Question(24,"¿De que país es originario el Tetris?",false,0,"Rusia","Japón","Estados Unidos","Alemania","Videojuegos",false))
        questions.add(Question(25,"¿Desde que FIFA salio el jugador Ronaldihno?",false,0,"2006","2000","2010","1998","Videojuegos",false))


    }

    //obtener contestadas

    val obtenerContestadas
       get() = contAnswered

    //sumar cada que se contesta

    fun Contestadas (){
        contAnswered++
    }
    //reinicio de hints consecutivas
    fun restartHintsConsect(){
        HintsConsecutiva = 0
    }

    // obtener las hints consecutivas

    val hintsConsecutivas : Int
        get() = HintsConsecutiva

    //aumentar las hints consecutivas

    fun aumentHintsConsect(){
        HintsConsecutiva++
    }

    // obtener hints
    val HintsTotal : Int
        get() = hintsTotal

    //Uso de hints
    fun disminHints(){
        if (hintsTotal >= 1) {
            hintsTotal -= 1
        }
    }

    //Aumentar hint
    fun aumentHints(){
        hintsTotal++
    }

    //Mostrar que se uso una hint
    val UsasteHints : Boolean
        get() = shuffQuestions[currentQuestionIndex].usoHint

    fun MostarUsoHint (){
         shuffQuestions[currentQuestionIndex].usoHint = true
//        return shuffQuestions[currentQuestionIndex].usoHint
    }

    //Puntaje
    val points: Int
        get() = puntaje

    //Puntaje malo por hints

    val MenosPorHints : Int
        get()= PuntosMenosHints

    //Sumar puntos malos de los hints

    fun MalosPuntos(){
        PuntosMenosHints += 2
    }

    //obtener lista de preguntas
    val Preguntas : List<Question>
        get() = questions

    // poner en aleatorio las preguntas
    var shuffQuestions = questions.shuffled()

    //obtener current index
    val Totalindex : String
        get() = (currentQuestionIndex + 1).toString()

    //obtener el size de la lista
    val sizeIndex : String
        get() = "/"+ (shuffQuestions.size).toString()

    val currentIndex: Int
        get() = currentQuestionIndex

    val answered: Boolean
        get() = shuffQuestions[currentQuestionIndex].answered

    //obtener la pregunta
    val currentQuestionText: String
        get() = shuffQuestions[currentQuestionIndex].text

    //obtener tema

    val currentQuestionTema : String
        get() = shuffQuestions[currentQuestionIndex].tema

    //reasignar respuestas ya shuffleadas

    val currentQuestionAnswer : String
        get() = shuffQuestions[currentQuestionIndex].correctAnswer

    val currentQuestionAnswerBad1 : String
        get() = shuffQuestions[currentQuestionIndex].incorrect1

    val currentQuestionAnswerBad2 : String
        get() = shuffQuestions[currentQuestionIndex].incorrect2

    val currentQuestionAnswerBad3 : String
        get() = shuffQuestions[currentQuestionIndex].incorrect3


    //Botones Next y Prev

    fun nextQuestion() {
        currentQuestionIndex = (currentQuestionIndex + 1) % 10 //es modulo 10 para que solo muestre 10
    }

    fun prevQuestion(){
        if(currentQuestionIndex<=0){
            currentQuestionIndex = questions.size -16
        } else{
            currentQuestionIndex -= 1
        }
    }

    //checar si es correcta la respuesta

    fun compare(string: String): Boolean{
        return string == shuffQuestions[currentQuestionIndex].correctAnswer
    }

    //puntaje

    fun addPoints() {
        puntaje += 20
    }
    fun popPoints() {
        if (puntaje>0) puntaje -= 10
    }

    fun lessPointsHints(){
        if(puntaje>0) puntaje -=2

    }
}