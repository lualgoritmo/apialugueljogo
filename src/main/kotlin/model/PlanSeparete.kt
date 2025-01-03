package model

import java.math.BigDecimal

 class PlanSeparete(planType: String): Plan(planType = planType) {

    override fun getPlanValue(rent: Rent): BigDecimal? =
         rent.game.cheapestPriceEver?.price?.toBigDecimal()?.times(rent.period.inDays.toBigDecimal())

}
