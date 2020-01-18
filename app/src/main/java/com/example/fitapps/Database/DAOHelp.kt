package com.example.fitapps.Database

import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase


@Database(entities = [Users::class], version = 1)
public abstract class DAOHelp : RoomDatabase()

{

    abstract fun getUserDao(): DAO
    val db = databaseBuilder(
        applicationContext,
        DAO::class.java, "database-name"
    ).build()

}