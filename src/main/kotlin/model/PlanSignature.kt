package model

class PlanSignature(
    planType: String,
    val monthlyFee: String,
    val quantityGames: Int
): Plan(planType = planType) {

}