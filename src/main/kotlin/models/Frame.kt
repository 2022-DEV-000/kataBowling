package models

sealed class Frame {
    companion object{
        fun fromThrows(first: Int, second: Int? = null, third: Int? = null) : Frame =
            when {
                //Last frame strike
                first == 10 && third != null -> Last(Strike,second ?:0,third)
                //Last frame spare
                third != null ->
                    Last(frame = fromThrows(first, second), firstBonus = third)
                //Strike
                first == 10 -> Strike
                //Spare frame
                first + (second ?: 0) == 10 -> Spare(first)
                else -> Open(first,second ?: 0)
            }

    }
}
object Strike : Frame()
data class Spare(val first : Int) : Frame()
data class Open(val first : Int, val second : Int) : Frame()
data class Last(val frame: Frame, val firstBonus : Int? = null, val secondBonus : Int? = null) : Frame()
