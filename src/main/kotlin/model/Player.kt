package model

import BRONZE
import java.util.*
import kotlin.random.Random

data class Player(var name: String, var email: String): Recommended {
    var dateOfBirth: String? = null
    var userGamer: String? = null
        set(value) {
            field = value
            if (value.isNullOrBlank()) {
                createIdIdentifier()
            }
        }
    var listGamer: MutableList<GameInfo?> = mutableListOf()
    val rentedGames: MutableList<Rent> = mutableListOf()
    private val noteList:MutableList<Int> = mutableListOf()
     val recommendedGame:MutableList<InfoGame> = mutableListOf()
    var planType: Plan = PlanSeparete(planType = BRONZE)
    var idIdentifier: String? = null
        private set
    override val average: Double
        get() = noteList.average()
    override fun recommended(note: Int) {
        if(note < 1 || note > 10) {
            println("Está nota não é válida, apenas entre 1 e 10")
        }else {
            noteList.add(note)
        }
    }

    constructor(name: String, emailUser: String, dateOfBirth: String, userGamer: String) :
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
        if (regex.matches(email)) {
            return email
        } else {
            throw RuntimeException("Email inválido!")
        }
    }

    override fun toString(): String {
        return "Jogador " +
                "name='$name',\n" +
                " email='$email', \n" +
                "dateOfBirth = $dateOfBirth,\n" +
                " user=$userGamer, \n" +
                "idInterno = $idIdentifier)\n" +
                "Reputação = $average"
    }
    fun rentToDo(game: GameInfo, periodRental: PeriodRental): Rent {
        val rent = Rent(
            player = this, game = game,
            period = periodRental
        )
        rentedGames.add(rent)
        return rent
    }
    fun recomnedGamer(game: InfoGame, note:Int) {
        this.recommended(note)
       this.recommendedGame.add(game)
    }
    fun gamesOfMorth(month: Int): List<GameInfo> = rentedGames.filter {
        rent -> rent.period.dateInit.monthValue == month }
        .map { rent -> rent.game }


    fun getRentMonth(periodRental: PeriodRental, letter: String): List<GameInfo> {
        return rentedGames
            .filter { it.period.dateInit.month == periodRental.dateInit.month }
            //filter { it.game.info.title.startsWith(letter, ignoreCase = true)}
            .filter { it.game.title.contains(letter, ignoreCase = true) }
            .map { it.game }
    }

    fun getTotalRent(): Double = rentedGames.sumOf { it.priceRent ?: 0.0 }

    companion object {
        fun createGame(scanner: Scanner): Player {
            println("Qual o seu nome?")
            val name = scanner.nextLine()
            println("Qual o seu email?")
            val email = scanner.nextLine()
            println("Usuário e data de nascimento S/N ?")
            val option = scanner.nextLine()
            if (option.equals("s", ignoreCase = true)) {
                println("Data de Nascimento DD//MM/AAAA?")
                val dateOfBirth = scanner.nextLine()
                println("Digite o seu nome de usuário?")
                val userName = scanner.nextLine()

                return Player(name = name, emailUser = email, dateOfBirth = dateOfBirth, userGamer = userName)
            } else {
                return Player(name = name, email = email)
            }
        }
    }

}
