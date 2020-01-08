package com.example.fitapps.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Users::class), version = 1)
abstract class DAOHelp : RoomDatabase(){
    abstract fun wordDao(): DAO
    companion object {
        private var INSTANCE: DAOHelp? = null
        fun getDatabase(context: Context): DAOHelp? {
            if (INSTANCE == null) {
                synchronized(DAOHelp::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        DAOHelp::class.java, "fit.db"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}