package model

sealed class Plan(val planType: String) {
    open fun getPlanValue(rent: Rent): Double = rent.game.price * rent.period.inDays.toDouble()

}
