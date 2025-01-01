package service

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import convertToPlayer
import model.GameResponse
import model.InfoPlayerJson
import model.Player
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class API {

    private fun consumerAPI(link:String):String {
        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(link))
            .build()

        val json = client.send(request, HttpResponse.BodyHandlers.ofString())
        return json.body()
    }

    fun getPlayers(): List<Player> {
        val uri = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = consumerAPI(uri)

        val gson = Gson()
        val gamerType = object : TypeToken<List<InfoPlayerJson>>() {}.type

        val listPlayers = gson.fromJson<List<InfoPlayerJson>>(json, gamerType)
        return listPlayers.map { it.convertToPlayer() }
    }

    fun getGame(idGame: String): GameResponse {
        val uri = "https://www.cheapshark.com/api/1.0/games?id=$idGame"
        val json = consumerAPI(uri)
        val gson = Gson()
        val game = gson.fromJson(json, GameResponse::class.java)

        return game
    }

}
