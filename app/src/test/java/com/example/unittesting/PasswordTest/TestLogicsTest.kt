package com.example.unittesting.PasswordTest

import com.example.unittesting.Utils.TestLogics
import junit.framework.TestCase.assertEquals
import org.junit.Test

class TestLogicsTest {

    @Test
    fun checkPassword_ValidPasswordLongEnough() {
        // Arrange
        val testLogics = TestLogics()
        // Act
        val result = testLogics.checkPassword("Password1")
        // Assert
        assertEquals("Valid", result) // Meets all conditions
    }

    @Test
    fun checkPassword_InvalidPasswordLongEnough() {
        // Arrange
        val testLogics = TestLogics()
        // Act
        val result = testLogics.checkPassword("password") // No uppercase or digit
        // Assert
        assertEquals("Invalid", result)
    }

    @Test
    fun checkPassword_ValidPasswordTooShort() {
        // Arrange
        val testLogics = TestLogics()
        // Act
        val result = testLogics.checkPassword("P1") // Meets regex but length <= 5
        // Assert
        assertEquals("Invalid", result)
    }

    @Test
    fun checkPassword_InvalidPasswordTooShort() {
        // Arrange
        val testLogics = TestLogics()
        // Act
        val result = testLogics.checkPassword("p1") // No uppercase and length <= 5
        // Assert
        assertEquals("Invalid", result)
    }

    @Test
    fun checkPassword_ValidPasswordTooShortLengthTest() {
        val testLogics = TestLogics()
        val result = testLogics.checkPassword("A1b2") // Meets regex but length <= 5
        assertEquals("Invalid", result) // This ensures the length condition is tested
    }

    @Test
    fun checkPassword_InvalidPasswordTooShortAndInvalidRegex() {
        val testLogics = TestLogics()
        val result = testLogics.checkPassword("p1") // Too short & missing uppercase
        assertEquals("Invalid", result)
    }
}
