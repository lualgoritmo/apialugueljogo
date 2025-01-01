package model

data class GameResponse(
    val info: Info,
    val cheapestPriceEver: CheapestPrice?
)
