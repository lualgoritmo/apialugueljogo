package model

class PlanSignature(
    planType: String,
    val monthlyFee: String,
    val quantityGames: Int
): Plan(planType = planType) {
    override fun getPlanValue(rent: Rent): Double {
        val totalGames = rent.player.gamesOfMorth(rent.period.dateInit.monthValue).size+1
        return if (totalGames <= quantityGames) {
          0.0
        } else {
            super.getPlanValue(rent)
        }
    }
}