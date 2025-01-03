package model

import java.math.BigDecimal

 open class Plan(val planType: String) {

    open fun getPlanValue(rent: Rent): BigDecimal? =
        rent.game.cheapestPriceEver?.price?.toBigDecimal()?.times(rent.period.inDays.toBigDecimal())
}