package parser

import models.Game

class BowlingParser : GameParser {

    private val allowedFrames = Regex("[-0-9X][-0-9X/]{0,2}")

    override fun parse(frames: String): Game {
        TODO("Not yet implemented")
    }

    fun asFrame(frame: String) {
        require(allowedFrames.matches(frame)) { "Invalid frame '$frame'" }
    }

}