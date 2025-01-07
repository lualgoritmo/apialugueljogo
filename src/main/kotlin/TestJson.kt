
import model.PeriodRental
import model.PlanSignature
import service.API
import java.time.LocalDate

fun main() {
    val api = API()

    val listGamer1 = api.getGame("151")
    val listGamer2 = api.getGame("149")
    val listGamer3 = api.getGame("133")

    val listPlayer = api.getPlayers()
    println()
    val jogador = listPlayer[3]

    val game1 = listGamer1
    val game2 = listGamer2
    val game3 = listGamer3

    val period1: PeriodRental = PeriodRental(dateInit = LocalDate.now(), dateEnd = LocalDate.now().plusDays(7))
    val period2: PeriodRental = PeriodRental(dateInit = LocalDate.now(), dateEnd = LocalDate.now().plusDays(3))
    val period3: PeriodRental = PeriodRental(dateInit = LocalDate.now(), dateEnd = LocalDate.now().plusDays(2))

     jogador.rentToDo(game = game1, periodRental = period1)
     jogador.rentToDo(game = game2, periodRental = period2)
     jogador.rentToDo(game = game3, periodRental = period3)
    //println(" $game1 ")
    val camila = listPlayer[5]
    camila.planType = PlanSignature(planType = PRATA, "9,90", QUANTITY)
    camila.rentToDo(game = game3, periodRental = period3)
    camila.rentToDo(game = game2, periodRental = period2)
    camila.rentToDo(game = game2, periodRental = period1)
    camila.rentToDo(game = game1, periodRental = period2)
    camila.rentToDo(game = game1, periodRental = period3)
    println("------------")
    println("Caroline")
    //jogador.rentedGames.forEach { println(it) }
   // println("Total: ${jogador.getTotalRent()}")
    println("----------------")
    println("Camila")
    camila.rentedGames.forEach { println(it) }
    println("Total: ${camila.getTotalRent()}")
//    println("-----------")
//    println("Lista filtrada: ${jogador.rentToDo(game1, period1)}")

}
