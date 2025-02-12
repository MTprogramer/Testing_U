package com.example.unittesting.RoomDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao
{
    @Insert
    suspend fun insert (user : Users)

    @Query("SELECT * FROM Users")
    fun getAllUsers() : Flow<List<Users>>

    @Query("SELECT * FROM Users WHERE id = :id")
    suspend fun getUser(id : Int) : Users

     @Query("DELETE FROM Users WHERE id = :id")
     suspend fun deleteUser(id : Int)

     @Update
     suspend fun updateUser(user : Users)
}