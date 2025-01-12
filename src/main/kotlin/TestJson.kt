import model.PeriodRental
import model.PlanSeparete
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
//    val jogador = listPlayer[3]

    val game1 = listGamer1
    val game2 = listGamer2
    val game3 = listGamer3

    val period1: PeriodRental = PeriodRental(dateInit = LocalDate.now(), dateEnd = LocalDate.now().plusDays(7))
    val period2: PeriodRental = PeriodRental(dateInit = LocalDate.now(), dateEnd = LocalDate.now().plusDays(3))
    val period3: PeriodRental = PeriodRental(dateInit = LocalDate.now(), dateEnd = LocalDate.now().plusDays(2))

    val caroline = listPlayer[4]
    caroline.planType = PlanSignature(planType = PRATA, monthlyFee = "9.90", quantityGames = 3)
    caroline.rentToDo(game = game1, periodRental = period1)
    caroline.rentToDo(game = game2, periodRental = period2)
    caroline.rentToDo(game = game3, periodRental = period3)
    caroline.rentToDo(game = game1, periodRental = period1)

    caroline.recommended(10)
    caroline.recommended(10)
    caroline.recommended(10)


//    println("----------------")
//    println("Jogador: ${caroline.name}")
//    println("Quantidade de Jogos: ${ caroline.rentedGames.size }")
    println("Quantidade de Jogos: ${ caroline.rentedGames }")
    println("-----------------")
    //println("Jogos Alugados: ${caroline.getTotalRent()} ")
//    println()
//    println("------------------------")
//    println("Total de aluguel:${caroline.getTotalRent()}")

//    caroline.rentedGames.forEachIndexed { index, rent ->
//        val status = if (index < 3) "Grátis" else "Pago"
//        println("  ${index + 1}. ${rent.game.info.title} - Preço: ${if (status == "Grátis") "Grátis" else "R$ %.2f".format(rent.priceRent)} ($status)")
//    }
//    val totalPrice = caroline.rentedGames.drop(3).sumOf { it.priceRent }
//    println("Total Pago: R$ %.2f".format(totalPrice))
    println("-------------------")
}
