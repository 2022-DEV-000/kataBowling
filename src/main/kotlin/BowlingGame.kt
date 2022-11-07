import models.Game
import parser.BowlingParser
import parser.GameParser

class BowlingGame (
    private val gameParser: GameParser = BowlingParser,

    ) {
        infix fun totalScore(frames: String): Int {
            val game: Game = gameParser.parse(frames)
            return 0
        }
}