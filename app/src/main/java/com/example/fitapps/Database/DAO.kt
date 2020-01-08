package com.example.fitapps.Database

import androidx.room.Insert
import androidx.room.Query

interface DAO {

    @Insert
    fun insert(users: Users)
    @Query("DELETE FROM User")
    fun deleteAll()
    @Query("SELECT * FROM User ORDER BY Name ASC" )
    fun getAllUsers() : List<Users>

}