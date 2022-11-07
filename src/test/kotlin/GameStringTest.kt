import org.junit.Assert
import org.junit.Test

class GameStringTest {

    @Test
    fun strikes_only() {
        Assert.assertEquals(300, BowlingGame().totalScore("X X X X X X X X X XXX"))
    }

    @Test
    fun nine_and_miss() {
        Assert.assertEquals(90, BowlingGame().totalScore("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-"))
    }

    @Test
    fun spare_of_five() {
        Assert.assertEquals(150, BowlingGame().totalScore("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5"))
    }

    @Test
    fun random() {
        Assert.assertEquals(129, BowlingGame().totalScore("17 X 1/ 43 4/ 07 X 7/ 53 X9/"))
    }

    @Test
    fun not_enough_frames() {
        val exception = Assert.assertThrows(IllegalArgumentException::class.java) {
            BowlingGame().totalScore("17 X 1/ 43 4/")
        }
        Assert.assertTrue(exception.message!!.contains("Invalid number of frames, was 5 and must be 10"))
    }

    @Test
    fun too_much_frames() {
        val exception = Assert.assertThrows(IllegalArgumentException::class.java) {
            BowlingGame().totalScore("17 X 1/ 43 4/ 51 22 07 X 7/ 53 X9/")
        }
        Assert.assertTrue(exception.message!!.contains("Invalid number of frames, was 12 and must be 10"))
    }

}