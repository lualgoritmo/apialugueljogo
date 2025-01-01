package model

data class Info(
    val title: String,
    val thumb: String,
    var description: String? = null
) {
    override fun toString(): String {
        return "JOGO: \n" +
                "TItulo:$title \n" +
                "Capa:$thumb \n" +
                //"Preço:${price} \n" +
                "Descrição: $description"
                //"Preço: $price"
    }
}
