package parser

import models.Game

interface GameParser {
    fun parse(frames: String): Game
}
