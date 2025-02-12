package com.example.unittesting.mock

class UserService (private val userRepo: UserRepo)
{
    fun login_user(email : String, password : String) : String
    {
        val status = userRepo.login_user(email,password)
       return when(status)
        {
            Response.INVALID_USER -> "Invalid User"
            Response.INVALID_PASSWORD -> "Invalid Password"
            Response.UNKNOWN_ERROR -> "Unknown Error"
            Response.SUCCESS -> "Success"
        }
    }

}