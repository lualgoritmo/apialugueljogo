package model

class PlanSignature(
    planType: String,
    val monthlyFee: String,
    val quantityGames: Int,
   // private val percentage: Double
): Plan(planType = planType) {
    override fun getPlanValue(rent: Rent): Double {
        val totalGames = rent.player.gamesOfMorth(rent.period.dateInit.monthValue).size+1
        return if (totalGames <= quantityGames) {
          0.0
        } else {
            var valueOrigin = super.getPlanValue(rent)
            if(rent.player.average > 8) {
                valueOrigin -= valueOrigin * 0.2
            }
             valueOrigin
        }
    }
}
