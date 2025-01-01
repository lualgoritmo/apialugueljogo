
import model.PeriodRental
import service.API
import java.time.LocalDate

fun main() {
    val api = API()

    val listGamer = api.getGame("133")
    val listPlayer = api.getPlayers()
    println()
    val jogador = listPlayer[3]
    val game = listGamer
    val period: PeriodRental = PeriodRental(dateInit = LocalDate.now(), dateEnd = LocalDate.now().plusDays(7))
    val rent = jogador.rentToDo(game = game, periodRental = period)
    println(rent)

}
