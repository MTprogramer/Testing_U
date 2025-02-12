package com.example.unittesting.mock

data class User(
    val email : String,
    val password : String
)

enum class Response{
    INVALID_USER,
    INVALID_PASSWORD,
    UNKNOWN_ERROR,
    SUCCESS
}