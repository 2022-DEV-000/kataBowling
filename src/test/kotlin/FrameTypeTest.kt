import models.*
import org.junit.Assert
import org.junit.Test

class FrameTypeTest {

    @Test
    fun strike(){
        Assert.assertEquals(Strike, Frame.fromThrows(10))
    }

    @Test
    fun open(){
        Assert.assertEquals(Open(5,2), Frame.fromThrows(5,2))
    }

    @Test
    fun spare(){
        Assert.assertEquals(Spare(2), Frame.fromThrows(2,8))
    }

    @Test
    fun last_spare(){
        Assert.assertEquals(Last(Spare(2),10), Frame.fromThrows(2,8,10))
    }

    @Test
    fun last_strike(){
        Assert.assertEquals(Last(Strike,10,10), Frame.fromThrows(10,10,10))
    }
}