package model

interface Recommended {
    val average: Double
    fun recommended(note: Int)
}
