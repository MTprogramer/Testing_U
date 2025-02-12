package com.example.unittesting.mock

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any

class UserTest{

    @Mock
    lateinit var userRepo: UserRepo

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
        Mockito.`when`(userRepo.login_user(anyString(), anyString())).thenReturn(Response.SUCCESS)
    }

    @Test
    fun textUserService()
    {
        val userService = UserService(userRepo)

        val result = userService.login_user("abc@gmail.com","233243")

        assertEquals("Success",result)
    }


}