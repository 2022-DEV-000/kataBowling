import models.Last
import models.Open
import models.Spare
import models.Strike
import org.junit.Assert
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Test
import parser.BowlingParser

class ParserTest {

        val parse = BowlingParser::asFrame

    @Test
    fun random_open() {
        Assert.assertEquals(Open(2,5), parse("25"))
    }

    @Test
    fun strike() {
        Assert.assertEquals(Strike, parse("X"))
    }

    @Test
    fun spare_random() {
        Assert.assertEquals(Spare(2), parse("2/"))
    }

    @Test
    fun spare_miss() {
        Assert.assertEquals(Spare(0), parse("-/"))
    }

    @Test
    fun two_miss() {
        Assert.assertEquals(Open(0,0), parse("--"))
    }

    @Test
    fun miss_open() {
        Assert.assertEquals(Open(0,2), parse("-2"))
    }

    @Test
    fun open_miss() {
        Assert.assertEquals(Open(2,0), parse("2-"))
    }

    @Test
    fun tenth_3_strike() {
        Assert.assertEquals(Last(Strike,10,10), parse("XXX"))
    }

    @Test
    fun tenth_strike_spare() {
        Assert.assertEquals(Last(Strike,1,9), parse("X1/"))
    }

    @Test
    fun tenth_strike_open() {
        Assert.assertEquals(Last(Strike,1,2), parse("X12"))
    }

    @Test
    fun tenth_strike_open_miss() {
        Assert.assertEquals(Last(Strike,1,0), parse("X1-"))
    }

    @Test
    fun tenth_spare_strike() {
        Assert.assertEquals(Last(Spare(2),10,null), parse("2/X"))
    }

    @Test
    fun tenth_spare_open() {
        Assert.assertEquals(Last(Spare(2),1,null), parse("2/1"))
    }
    
    @Test
    fun empty_string() {
        val exception = assertThrows(IllegalArgumentException:: class.java){
            parse("")
        }
        assertTrue(exception.message !!.contains("Invalid frame ''"))
    }

    @Test
    fun too_long_string() {
        val exception = assertThrows(IllegalArgumentException:: class.java){
            parse("5222")
        }
        assertTrue(exception.message !!.contains("Invalid frame '5222'"))
    }

}