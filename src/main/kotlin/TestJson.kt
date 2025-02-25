import com.google.gson.GsonBuilder
import model.PeriodRental
import model.PlanSeparete
import model.PlanSignature
import service.API
import java.time.LocalDate

fun main() {
    val consumo = API()
    val listaGamers = consumo.getPlayers()
    val listaJogoJson = consumo.listGames()
    println(listaGamers)
//    val period1: PeriodRental = PeriodRental(dateInit = LocalDate.now(), dateEnd = LocalDate.now().plusDays(7))
//    val period2: PeriodRental = PeriodRental(dateInit = LocalDate.now(), dateEnd = LocalDate.now().plusDays(3))
//    val period3: PeriodRental = PeriodRental(dateInit = LocalDate.now(), dateEnd = LocalDate.now().plusDays(2))
//
//    val caroline = listPlayer[4]
//   caroline.planType = PlanSignature(planType = PRATA, monthlyFee = "9.90", quantityGames = 3, 0.15)
////    caroline.rentToDo(game = game1, periodRental = period1)
////    caroline.rentToDo(game = game2, periodRental = period2)
////    caroline.rentToDo(game = game3, periodRental = period3)
//
//    val spider = api.getGame("13")
//    val jogoResidentVillage  = api.getGame("10")
//    val jogoTheLastOfUs  = api.getGame("2")
//    val jogoDandara  = api.getGame("3")
//    val jogoAssassins   = api.getGame("3")
//    val jogoCyber   = api.getGame("6")
//    val jogoGod   = api.getGame("7")
//    val jogoSkyrim   = api.getGame("18")
//    caroline.listGamer.get(3)
//    caroline.recommended(10)
//    caroline.recommended(10)
//    caroline.recommended(10)
//    caroline.recomnedGamer(game = game1, note = 10)
//    caroline.recomnedGamer(game = game2, note = 10)
//    caroline.recomnedGamer(spider, 5)
//    caroline.recomnedGamer(jogoResidentVillage, 7)
//    caroline.recomnedGamer(jogoDandara, 7)
//    caroline.recomnedGamer(jogoAssassins, 8)
//    caroline.recomnedGamer(jogoCyber, 9)
//    caroline.recomnedGamer(jogoGod, 7)
//    caroline.recomnedGamer(jogoSkyrim, 10)
//    caroline.recomnedGamer(jogoTheLastOfUs, 9)
//    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
//    val json = gson.toJson(caroline.listGamer)
   // val esse  = caroline.rentToDo(game = game1, periodRental = period1)

//    println("----------------")
//    println("Jogador: ${caroline.name}")
//    println("Quantidade de Jogos: ${ caroline.rentedGames.size }")
    //println("Quantidade de Jogos: ${ caroline.rentedGames }")
    //println(caroline.listGamer.get(3))
    println("-----------------")
    //println("Esse $esse")
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

}
