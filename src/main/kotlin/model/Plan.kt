package model

 open class Plan(val planType: String) {
    open fun getPlanValue(rent: Rent): Double =
        rent.game.cheapestPriceEver.price.toDouble() * rent.period.inDays.toDouble()
}
