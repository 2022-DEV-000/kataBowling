package parser

import models.Frame
import models.Game

object BowlingParser : GameParser {

    private val allowedFrames = Regex("[-0-9X][-0-9X/]{0,2}")

    override fun parse(frames: String): Game {
        TODO("Not yet implemented")
    }

    fun asFrame(frame: String) : Frame {
        require(allowedFrames.matches(frame)) { "Invalid frame '$frame'" }
        val first = frame[0].toValue()
        val second = frame.getOrNull(1)?.toValue(frame[0])
        val third = frame.getOrNull(2)?.toValue(frame.getOrNull(1))
        return Frame.fromThrows(first, second, third)
    }

    private fun Char.toValue(previous: Char? = null): Int =
        when (this) {
            "X".single() -> 10
            "-".single() -> 0
            "/".single() -> (10 - (previous?.toValue() ?: 0))
            else -> Character.getNumericValue(this)
        }

}