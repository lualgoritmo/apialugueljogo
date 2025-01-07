package model

 class PlanSeparete(planType: String): Plan(planType = planType) {
    override fun getPlanValue(rent: Rent): Double =
         rent.game.cheapestPriceEver.price.toDouble() * rent.period.inDays.toDouble()

}
