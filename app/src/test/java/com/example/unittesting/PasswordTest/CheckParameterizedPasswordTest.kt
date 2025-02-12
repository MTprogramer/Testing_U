package com.example.unittesting.PasswordTest

import com.example.unittesting.Utils.TestLogics
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class CheckParameterizedPasswordTest(val password: String, val expectedResult: String)
{
    @Test
    fun checkPassword_ValidPassword() {
        // Arrange
        val testLogics = TestLogics()
        // Act
        val result = testLogics.checkPassword(password)
        // Assert
        assertEquals(expectedResult, result)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() : List<Array<Any>>
        {
            return listOf(
                arrayOf("Password1" , "Valid"),
                arrayOf("password" , "Invalid"),
                arrayOf("P1" , "Invalid"),
                arrayOf("p1" , "Invalid"),
                arrayOf("A1b2" , "Invalid"),
                arrayOf("p1" , "Invalid")
             )
        }
    }

}