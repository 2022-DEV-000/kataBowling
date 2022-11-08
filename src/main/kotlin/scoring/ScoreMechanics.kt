import models.*

object Score {
    fun score(game: Game): Int {
        require(game.frames.size == 10) { "Invalid number of frames, was ${game.frames.size} and must be 10" }
        return score(game.frames, 1, 0)
    }

    private tailrec fun score(frames: List<Frame>, turn: Int, score: Int): Int =
        when {
            frames.isEmpty() || turn > 10 -> score
            else -> {
                val tail = frames.drop(1)
                val newScore = score + scoreFrame(frames.first(), frames.getOrNull(1), frames.getOrNull(2))
                score(tail, turn.inc(), newScore)
            }
        }

    fun scoreFrame(currentFrame: Frame, nextFrame: Frame?, afterNextFrame: Frame?): Int {
        val (firstNextRoll, secondNextRoll) = getFollowingTwoThrows(nextFrame, afterNextFrame)
        return when (currentFrame) {
            is Strike -> 10 + firstNextRoll + secondNextRoll
            is Spare -> 10 + firstNextRoll
            is Open, is Last -> currentFrame.countTotal()
        }
    }

    private fun getFollowingTwoThrows(nextFrame: Frame?, afterNextFrame: Frame?): Pair<Int, Int> =
        when (nextFrame) {
            is Strike? -> Pair(10, afterNextFrame?.countFirst() ?: 0)
            is Open? -> Pair(nextFrame?.first ?: 0, nextFrame?.second ?: 0)
            is Spare? -> Pair(nextFrame?.first ?: 0, 10 - (nextFrame?.first ?: 0))
            is Last? -> getFollowingTwoThrows(nextFrame?.frame, Open(nextFrame?.firstBonus ?: 0, 0))
            null -> Pair(0, 0)
        }
}