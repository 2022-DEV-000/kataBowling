import models.Open
import models.Spare
import models.Strike
import org.junit.Assert
import org.junit.Test

class FrameScoreTest {

    val scoreFrame = Score::scoreFrame

    @Test
    fun last_strike_strike_strike() {
        Assert.assertEquals(30, scoreFrame(Strike,Strike,Strike))
    }

    @Test
    fun strike_strike() {
        Assert.assertEquals(20, scoreFrame(Strike,Strike,null))
    }

    @Test
    fun strike_spare() {
        Assert.assertEquals(20, scoreFrame(Strike,Spare(4),null))
    }

    @Test
    fun strike_open() {
        Assert.assertEquals(17, scoreFrame(Strike, Open(4,3),null))
    }

    @Test
    fun spare_strike() {
        Assert.assertEquals(20, scoreFrame(Spare(4),Strike,null))
    }

    @Test
    fun spare_spare() {
        Assert.assertEquals(12, scoreFrame(Spare(4),Spare(2),null))
    }

    @Test
    fun spare_open() {
        Assert.assertEquals(12, scoreFrame(Spare(4),Open(2,5),null))
    }

    @Test
    fun open(){
        Assert.assertEquals(8, scoreFrame(Open(3,5),null,null))
    }
}