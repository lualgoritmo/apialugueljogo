package model

import com.google.gson.annotations.Expose

data class GameInfo(
    @Expose val title: String,
    @Expose val thumb: String
): Recommended {
    var description: String? = null
    var price = 0.0
    private val noteList:MutableList<Int> = mutableListOf()
    override val average: Double
        get() = noteList.average()
    override fun recommended(note: Int) {
        if(note < 1 || note > 10) {
            println("Está nota não é válida, apenas entre 1 e 10")
        }else {
            noteList.add(note)
        }
    }

    override fun toString(): String {
        return "JOGO: \n" +
                "TItulo:$title \n" +
                "Capa:$thumb\n" +
                "Descrição: $description\n"
    }
}
