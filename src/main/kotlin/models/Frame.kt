package models

sealed class Frame {
    companion object{
        fun fromThrows(firstThrow: Int, secondThrow: Int? = null, thirdThrow: Int? = null) = Strike
    }
}
object Strike : Frame()
data class Spare(val first : Int) : Frame()
data class Open(val first : Int, val second : Int) : Frame()
data class Last(val frame: Frame, val firstBonus : Int? = null, val secondBonus : Int? = null)
