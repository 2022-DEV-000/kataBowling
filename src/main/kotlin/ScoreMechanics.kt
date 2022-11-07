import models.Game

object Score {
    fun score(game: Game): Int {
        require(game.frames.size == 10) { "Invalid number of frames, was ${game.frames.size} and must be 10" }
        return 0
    }
}