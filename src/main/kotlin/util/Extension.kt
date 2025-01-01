import model.InfoPlayerJson
import model.Player
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.validatedAge(): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val dateOfBirth = LocalDate.parse(this, formatter)

    return Period.between(dateOfBirth, LocalDate.now()).years

}

fun InfoPlayerJson.convertToPlayer(): Player = Player(this.nome, this.email, this.dataNascimento, this.usuario)

