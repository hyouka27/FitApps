package com.example.fitapps.DAO

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

class AppDatabase {
    @Database(entities = arrayOf(User::class), version = 1)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun userDao(): UserDao

    }
}