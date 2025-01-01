package model

data class Rent(
    val player: Player,
    val game: GameResponse,
    val period: PeriodRental
) {
    var priceRent = game.cheapestPriceEver?.price?.toBigDecimal()?.times(period.inDays.toBigDecimal())

    override fun toString(): String {
        return "Aluguel do Jogo:${game.info.title}, pelo Jogador: ${player.name}, Preço: $priceRent"
    }

}
