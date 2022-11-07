import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Test
import parser.BowlingParser

class ParserTest {

        val parse = BowlingParser::asFrame

        @Test
        fun empty_string() {
            val exception = assertThrows(IllegalArgumentException:: class.java){
                parse(BowlingParser(),"")
            }
            assertTrue(exception.message !!.contains("Invalid frame ''"))
        }

        @Test
        fun too_long_string() {
            val exception = assertThrows(IllegalArgumentException:: class.java){
                parse(BowlingParser(),"5222")
            }
            assertTrue(exception.message !!.contains("Invalid frame '5222'"))
        }

}