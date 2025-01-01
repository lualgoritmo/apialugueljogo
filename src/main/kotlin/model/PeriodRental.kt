package model

import java.time.LocalDate
import java.time.Period

data class PeriodRental(
    val dateInit: LocalDate,
    val dateEnd: LocalDate
) {
    val inDays: Int = Period.between(dateInit, dateEnd).days
}
