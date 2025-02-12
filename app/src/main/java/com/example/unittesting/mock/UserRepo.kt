package com.example.unittesting.mock

class UserRepo()
{
    val data = listOf(
        User("Mian@gmail.com","12345"),
        User("Mian2@gmail.com","12345"),
        User("Mian3@gmail.com","12345")
    )

    fun login_user(email : String, password : String) : Response
    {
        val user = data.filter { it.email == email }
        return if (user.size == 1) {
            if (user[0].password == password) {
                Response.SUCCESS
            } else
                Response.INVALID_PASSWORD
            } else
                Response.INVALID_USER
    }

}