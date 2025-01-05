package model

import java.math.BigDecimal

class PlanSignature(
    planType: String,
    val monthlyFee: String,
    val quantityGames: Int
): Plan(planType = planType) {
    override fun getPlanValue(rent: Rent): BigDecimal? {
        return super.getPlanValue(rent)
    }
}