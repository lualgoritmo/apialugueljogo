package model

data class Rent(
    val player: Player,
    val game: GameResponse,
    val period: PeriodRental
) {
    var priceRent: Double = player.planType.getPlanValue(rent = this)
    override fun toString(): String {
        return "" +
                "Aluguel do Jogo:\n" +
                "${game.info.title}" +
                "pelo Jogador: \n" +
                "${player.name} \n" +
                "Preço: $priceRent"
    }

}
