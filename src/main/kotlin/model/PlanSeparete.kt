package model

 class PlanSeparete(planType: String): Plan(planType = planType) {
     override fun getPlanValue(rent: Rent): Double {
         var valueOrigin = super.getPlanValue(rent)

         if(valueOrigin > 8) {
             valueOrigin -= valueOrigin * 0.1
         }
         return valueOrigin
     }
}
