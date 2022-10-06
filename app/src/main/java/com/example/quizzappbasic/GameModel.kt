package com.example.quizzappbasic

import androidx.lifecycle.ViewModel
import java.lang.Math.random

class GameModel : ViewModel() {

    private val questions = mutableListOf<Question>()
    private var currentQuestionIndex = 0



    init {

        questions.add(Question("¿Cual ha sido la pelicula más taquillera de la historia?",false,"Avengers:Endgame","Titanic","Avatar","Spiderman:No Way Home"))
        questions.add(Question("¿Cual fue la primera pelicula de Walt Disney",false,"Blancanieves","La cenicienta","La sirenita","Frozen"))
        questions.add(Question("¿Que pelicula NO es de Pixar?",false,"Hercules","Toy Story","Cars","Soul"))
        questions.add(Question("¿Cuantos premios Oscars gano la pelicula Titanic? ",false,"11","5","9","7"))
        questions.add(Question("¿En que año se estreno la pelicula Matrix?",false,"1999","2000","1997","2001"))
        questions.add(Question("¿De que color es el pelaje de un oso polar?",false,"Transparente","Blanco","Marron","Negro"))
        questions.add(Question("¿Cuantos corazones tiene un pulpo?",false,"3","2","1","No tiene"))
        questions.add(Question("¿Qué animal tiene los dientes más grandes?",false,"Narval","Morsa","Elefante","Castor"))
        questions.add(Question("¿Cuantos parpados tienen los camellos en cada ojo?",false,"3","2","No tienen","4"))
        questions.add(Question("¿Cual es el animal más grande del mundo?",false,"Ballena Azul","Tiburon Ballena","Orca","Calamar gigante"))
        questions.add(Question("¿Cual es el océano más grande del mundo?",false,"Pácifo","Atlántico","Índico","Antártico"))
        questions.add(Question("¿Cual es el país más pequeño del mundo?",false,"El Vaticano","Grenada","Monaco","Barbados"))
        questions.add(Question("¿Cuantos huesos tiene el cuerpo humano?",false,"206","200","157","189"))
        questions.add(Question("¿Cuantos años tiene un lustro?",false,"5","10","15","50"))
        questions.add(Question("Cual es el país del sol naciente?",false,"Japón","México","Colombia","Argentina"))
        questions.add(Question("¿Quien fue el primer presidente de México?",false,"Guadalupe Victoria","Miguel Hidalgo","Vicente Guerrero","José María Morelos"))
        questions.add(Question("¿A qué cultura pertenecen las cabezas colosales?",false,"Olmeca","Maya","Mexica","Nahuatls"))
        questions.add(Question("¿Que se celebra el 5 de mayo?",false,"Batalla de Puebla","La independencia","Guerra de los pasteles","Nada"))
        questions.add(Question("¿En que año inicio la Revolución Mexicana?",false,"1910","1810","1921","1917"))
        questions.add(Question("¿En que año fue la promulgación de la Constitución?",false,"1917","1821","1920","1810"))
        questions.add(Question("¿En que año salio la Nintendo 64?",false,"1996","1964","2000","1999"))
        questions.add(Question("¿En que planeta vive Kirby?",false,"Pop Star","Planet Robot","Dreamland","Pinball Land"))
        questions.add(Question("¿Cual es el videojuego más vendido en la historia?",false,"Wii Sports","Minecraft","Super Mario Bros","Mario Kart"))
        questions.add(Question("¿De que país es originario el Tetris?",false,"Rusia","Japón","Estados Unidos","Alemania"))
        questions.add(Question("¿Desde que FIFA salio el jugador Ronaldihno?",false,"2006","2000","2010","1998"))

    }



    // poner en aleatorio las preguntas

    val shuffQuestions = questions.shuffled()

    //obtener current index

    val Totalindex : String
        get() = (currentQuestionIndex + 1).toString()

    //obtener el size de la lista
    val sizeIndex : String
        get() = "/"+ (shuffQuestions.size - 15).toString()


    val currentIndex: Int
        get() = currentQuestionIndex

    //obtener la pregunta

    val currentQuestionText: String
        get() = shuffQuestions[currentQuestionIndex].text

    var answers = mutableListOf<String>(shuffQuestions[currentIndex].correctAnswer,shuffQuestions[currentIndex].incorrect1,shuffQuestions[currentIndex].incorrect2,shuffQuestions[currentIndex].incorrect3)

    val respuestas : List <String>
        get() = answers

    var shuffAnswers = respuestas.shuffled()

    val extraerShuffAnsw : List <String>
        get() = shuffAnswers



    //obtener respuestas

    val currentQuestionAnswer : String
        get() = extraerShuffAnsw[0]

    val currentQuestionAnswerBad1 : String
        get() = extraerShuffAnsw[1]

    val currentQuestionAnswerBad2 : String
        get() = extraerShuffAnsw[2]

    val currentQuestionAnswerBad3 : String
        get() = extraerShuffAnsw[3]



    //Botones Next y Prev

    fun nextQuestion() {
        currentQuestionIndex = (currentQuestionIndex + 1) % 10 //es modulo 10 para que solo muestre 10

        var answers = mutableListOf<String>(shuffQuestions[currentIndex].correctAnswer,shuffQuestions[currentIndex].incorrect1,shuffQuestions[currentIndex].incorrect2,shuffQuestions[currentIndex].incorrect3)
        var shuffAnswers = answers.shuffled()
    }

    fun prevQuestion(){
        if(currentQuestionIndex<=0){
            currentQuestionIndex = questions.size -1
        } else{
            currentQuestionIndex -= 1
        }
    }

    //validacion de contestación
    fun isAnswered(): Boolean{
        if(shuffQuestions[currentQuestionIndex].answered){
            return true
        }
        return false
    }

    //checar si es correcta la respuesta

    fun compare(string: String): Boolean{
        return string == shuffQuestions[currentQuestionIndex].correctAnswer
    }

}