package models

sealed class Frame {
    companion object{
        fun fromThrows(first: Int, second: Int? = null, third: Int? = null) : Frame =
            when {
                first == 10 && third == null -> Strike
                else -> Open(first,second ?: 0)
            }

    }
}
object Strike : Frame()
data class Spare(val first : Int) : Frame()
data class Open(val first : Int, val second : Int) : Frame()
data class Last(val frame: Frame, val firstBonus : Int? = null, val secondBonus : Int? = null)
