package util

import model.GameInfo
import model.InfoGameJson

fun InfoGameJson.createGame(): GameInfo{
    return GameInfo(title = this.title, this.thumb)
}