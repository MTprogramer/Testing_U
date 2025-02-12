package com.example.unittesting.Utils


class TestLogics {

    fun checkPassword(password: String): String {
        val regex = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]+")
        return if (regex.matches(password) && password.length >= 5)
            "Valid"
        else
            "Invalid"
    }

    fun StringReversal(input: String): String {
        val data = input.toCharArray()
        var start = 0
        var end = data.size - 1

        while (start < end) {
            // Swap characters
            val temp = data[start]
            data[start] = data[end]
            data[end] = temp

            // Move indices towards the center
            start++
            end--
        }
        return data.joinToString("")
    }


}
