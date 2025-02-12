package com.example.unittesting.RoomDB

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.util.concurrent.CountDownLatch

class DatabaseTest
{
    lateinit var database: Database
    lateinit var userDao: UserDao

    @Before
    fun setDatabase()
    {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider
                .getApplicationContext(),
                Database::class.java)
            .allowMainThreadQueries().build()
        userDao = database.userDao()
    }

    @Test
    fun insertUser()  = runTest{
        val user = Users(1,"Mian","Developer")
        userDao.insert(user)

        val users = userDao.getAllUsers().first()    // Collect only the first emission
        assertEquals(users[0].name, "Mian")
    }

    @Test
    fun updateUser() = runTest {
        val user = Users(1, "Mian", "Developer")
        userDao.insert(user)

        val updatedUser = Users(1, "Mian Updated", "Senior Developer")
        userDao.updateUser(updatedUser)

        val users = userDao.getAllUsers().first()
        assertEquals(users[0].name, "Mian Updated")  // Ensure the name was updated
    }

    @Test
    fun deleteUser() = runTest {
        val user = Users(1, "Mian", "Developer")
        userDao.insert(user)

        userDao.deleteUser(user.id)

        val users = userDao.getAllUsers().first()
        assertTrue(users.isEmpty())  // Ensure no users are left in the database
    }

    @After
    fun tearDown()
    {
        database.close()
    }
}