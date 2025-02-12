package com.example.unittesting

import com.example.unittesting.Utils.TestLogics
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ParameterizedStringReversal(val input: String, val expectedResult: String)
{
    @Test
    fun  stringReversal()
    {
        // Arrange
        val testLogics = TestLogics()
        // Act
        val result = testLogics.StringReversal(input)
        // Assert
        assertEquals(expectedResult , result)
    }

    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data() : List<Array<Any>>
        {
            return listOf(
                arrayOf("hello" , "olleh"),
                arrayOf("world" , "dlrow"),
                arrayOf("racecar" , "racecar"),
                arrayOf("" , ""),
                arrayOf("a" , "a")
            )
        }
    }

}