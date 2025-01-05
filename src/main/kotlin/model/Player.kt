package model

import BRONZE
import java.math.BigDecimal
import java.util.Scanner
import kotlin.random.Random

data class Player(var name: String, var email: String) {
    var dateOfBirth: String? = null
    var userGamer: String? = null
        set(value){
            field = value
            if(value.isNullOrBlank()) {
                createIdIdentifier()
            }
        }
    var listGamer: MutableList<Info?> = mutableListOf()
    val rentedGames: MutableList<Rent> = mutableListOf()
    var planType: Plan = PlanSeparete(planType = BRONZE)
    var idIdentifier: String? = null
        private set

    constructor(name:String,emailUser: String, dateOfBirth:String, userGamer:String) :
            this(name = name, email = emailUser) {
                this.dateOfBirth = dateOfBirth
                this.userGamer = userGamer
                createIdIdentifier()
            }
//
//    init {
//        this.email = validatedEmail()
//        if(this.name.isNullOrBlank()) {
//            throw RuntimeException("Prencha o nome")
//        }
//    }

     fun createIdIdentifier() {
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)
        idIdentifier = "$userGamer#$tag"
    }

    fun validatedEmail(): String {
        val regex = Regex(pattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
         if(regex.matches(email)) {
             return email
         } else {
             throw  RuntimeException("Email inválido!")
         }
    }

    override fun toString(): String {
        return "Jogador " +
                "name='$name'," +
                " email='$email', " +
                "dateOfBirth = $dateOfBirth," +
                " user=$userGamer, " +
                "idInterno = $idIdentifier)"
    }
    fun rentToDo(game: GameResponse, periodRental: PeriodRental): Rent {
        val rent = Rent(player = this, game = game,
            period = periodRental
        )
        rentedGames.add(rent)
        return rent
    }
    fun getRentMonth(periodRental: PeriodRental, letter: String): List<GameResponse> {
        return rentedGames
            .filter { it.period.dateInit.month == periodRental.dateInit.month }
            //filter { it.game.info.title.startsWith(letter, ignoreCase = true)}
            .filter { it.game.info.title.contains(letter, ignoreCase = true) }
            .map { it.game }
    }
    fun getTotalRent(): BigDecimal = rentedGames.sumOf { it.priceRent?: BigDecimal.ZERO }
    companion object {
        fun createGame(scanner:Scanner): Player {
            println("Qual o seu nome?")
            val name = scanner.nextLine()
            println("Qual o seu email?")
            val email = scanner.nextLine()
            println("Usuário e data de nascimento S/N ?")
            val option = scanner.nextLine()
            if(option.equals("s", ignoreCase = true)) {
                println("Data de Nascimento DD//MM/AAAA?")
                val dateOfBirth = scanner.nextLine()
                println("Digite o seu nome de usuário?")
                val userName = scanner.nextLine()

                return Player(name = name, emailUser = email, dateOfBirth = dateOfBirth, userGamer = userName)
            }else {
                return Player(name = name, email = email)
            }
        }
    }

}
