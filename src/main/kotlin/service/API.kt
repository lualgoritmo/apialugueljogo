package service

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import convertToPlayer
import model.*
import util.createGame
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class API {

    private fun consumerData(link:String):String {
        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(link))
            .build()

        val json = client.send(request, HttpResponse.BodyHandlers.ofString())
        println("Resposta da API: ${json.body()}")
        return json.body()
    }

    fun getGame(idGame: String): InfoGame {
        val uri = "https://www.cheapshark.com/api/1.0/games?id=$idGame"
        val json = consumerData(uri)
        val gson = Gson()
        val game = gson.fromJson(json, InfoGame::class.java)

        return game
    }
    fun getPlayers(): List<Player> {
        val uri = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = consumerData(uri)

        val gson = Gson()
        val gamerType = object : TypeToken<List<InfoPlayerJson>>() {}.type

        val listPlayers = gson.fromJson<List<InfoPlayerJson>>(json, gamerType)
        return listPlayers.map { it.convertToPlayer() }
    }

    fun listGames(): List<GameInfo> {
        val link = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = consumerData(link)

        val gson = Gson()
        val myType = object: TypeToken<List<InfoGameJson>>() {}.type
        val listGame: List<InfoGameJson> = gson.fromJson(json, myType)

        val listGameConverted = listGame.map { infoPlayerJson -> infoPlayerJson.createGame() }
        return listGameConverted
    }
}
