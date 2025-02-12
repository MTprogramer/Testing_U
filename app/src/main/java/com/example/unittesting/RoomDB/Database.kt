package com.example.unittesting.RoomDB

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = [Users::class], version = 1)
abstract class Database : RoomDatabase()  {

    abstract fun userDao() : UserDao

}