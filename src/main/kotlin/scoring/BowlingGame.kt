package scoring

import Score
import models.Game
import parser.BowlingParser
import parser.GameParser

class BowlingGame (
    private val gameParser: GameParser = BowlingParser,
    private val score: (Game) -> Int = Score::score

    ) {
        infix fun totalScore(frames: String): Int {
            val game: Game = gameParser.parse(frames)
            return score(game)
        }
}